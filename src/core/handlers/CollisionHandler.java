// TODO - New collision events

package core.handlers;

import core.registry.GameRegistryList;
import core.registry.ObjectRegistry;
import core.objects.BaseObject;
import core.objects.Collideable;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;
import core.objects.components.shape.hitboxes.CircleHitbox;
import core.objects.components.shape.hitboxes.Hitbox;
import core.objects.components.shape.hitboxes.RectangleHitbox;
import core.objects.main.GameObject;
import core.events.CollisionEvent;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler implements Handler {
	private GameRegistryList<Integer> ref =	new GameRegistryList<Integer>();
	private int checkStatus = 1; // Alternates between 1 and -1

	public void add(GameObject obj) {
		int i = this.ref.add(obj.getRegistryIndex());
		obj.setCollisionHandlerIndex(i);
	}

	public void remove(GameObject obj) {
		this.ref.remove(obj.getCollisionHandlerIndex());
	}

	public void clear() {
		this.ref.clear();
	}

	public void handle() {
		GameObject[] objects = ObjectRegistry.getWithReferenceList(this.ref);

		for (int i = 0; i < objects.length; i++) {
			this.handle(objects[i], objects);
		}

		this.checkStatus *= -1;
	}
	
	public void handle(GameObject obj1, GameObject[] objects) {
		List<Hitbox> hitboxes1 = this.extractHitboxes(obj1.components);
		Hitbox hitbox1;

		GameObject obj2;
		List<Hitbox> hitboxes2;
		Hitbox hitbox2;

		boolean isCollisionDetected = false;

		for (int i = 0; i < objects.length; i++) {
			obj2 = objects[i];

			if (!this.wasHandled(obj2) && obj1 != obj2) {
				hitboxes2 = this.extractHitboxes(obj2.components);

				for (int y = 0; y < hitboxes1.size(); y++) {
					for (int z = 0; z < hitboxes2.size(); z++) {
						hitbox1 = hitboxes1.get(y);
						hitbox2 = hitboxes2.get(z);

						if (hitbox2 instanceof CircleHitbox) {
							isCollisionDetected = hitbox1.checkCollision((CircleHitbox) hitbox2);
						} else if (hitbox2 instanceof RectangleHitbox) {
							isCollisionDetected = hitbox1.checkCollision((RectangleHitbox) hitbox2);
						}

						if (isCollisionDetected) {
							this.dispatchEvent(
								new CollisionEvent(hitbox2),
								(BaseComponent) hitbox1);
							this.dispatchEvent(
								new CollisionEvent(hitbox1),
								(BaseComponent) hitbox2);
						}
					}
				}
			}

			obj1.setCollisionCheckStatus(this.checkStatus);
		}
	}

	protected List<Hitbox> extractHitboxes(BaseComponent obj) {
		List<Hitbox> hitboxes = new ArrayList<Hitbox>();

		if (obj instanceof ComponentList) {
			for (BaseComponent comp : ((ComponentList<BaseComponent>) obj).getComponents()) {
				hitboxes.addAll(this.extractHitboxes(comp));
			}
		} else if (obj instanceof Hitbox) {
			hitboxes.add((Hitbox) obj);
		}

		return hitboxes;
	}
	
	private boolean wasHandled(GameObject obj) {
		return obj.getCollisionCheckStatus() == this.checkStatus;
	}

	private void dispatchEvent(CollisionEvent ev, BaseObject obj) {
		if (obj instanceof Collideable) {
			((Collideable) obj).onCollisionStart(ev);
		}

		if (obj instanceof BaseComponent) {
			BaseComponent compObj = (BaseComponent) obj;

			if (compObj.hasParent()) {
				this.dispatchEvent(ev, compObj.getParent());
			}
		}
	}
}
