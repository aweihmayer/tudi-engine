// TODO - New collision events, tree map

package core.handlers;

import core.objects.BaseObject;
import core.objects.Collideable;
import core.objects.components.BaseComponent;
import core.objects.components.body.Body;
import core.objects.main.GameObject;
import core.events.CollisionEvent;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler extends BaseHandler {
	public void add(GameObject obj) {
		if (obj instanceof Collideable) {
			super.add(obj);
		}
	}

	public void handle() {
		this.clean();
		GameObject[] objects = this.ref.toArray();

		for (int i = 0; i < objects.length; i++) {
			this.handle(
				this.getBodies(objects));
		}
	}

	private List<Body> getBodies(GameObject[] objects) {
		List<Body> bodies = new ArrayList<Body>();

		for (int i = 0; i < objects.length; i++) {
			bodies.add(objects[i].body);
		}

		return bodies;
	}

	public void handle(List<Body> bodies) {
		for (int i = 0; i < bodies.size(); i++) {
			for (int y = i + 1; y < bodies.size() - 1; y++) { // minus 1 i think for the end because the last one will already have been checked with all the others. The offset will be too long
				this.checkCollision(bodies.get(i), bodies.get(y));
			}
		}
	}

	public

	private void checkCollision(Body body1, Body body2) {
		if (body1.checkCollision(body2)) {
			this.dispatchEvent(body1, body2);
		}
	}

	private void dispatchEvent(Body body1, Body body2) {
		this.dispatchEvent(
			new CollisionEvent(body2),
			body1);

		this.dispatchEvent(
			new CollisionEvent(body1),
			body2);
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
