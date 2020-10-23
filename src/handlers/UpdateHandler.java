package handlers;

import gameObjects.BaseObject;
import gameObjects.components.BaseComponent;
import gameObjects.components.ComponentList;
import gameObjects.main.GameObject;
import handlers.events.UpdateEvent;
import gameObjects.Updateable;

public class UpdateHandler extends BaseHandler {
	private UpdateEvent lastUpdateEvent = new UpdateEvent();

	public void handle() {
		this.clean();
		GameObject[] objects = this.ref.toArray();
		GameObject obj;
		this.lastUpdateEvent = new UpdateEvent(this.lastUpdateEvent);

		for (int i = 0; i < objects.length; i++) {
			obj = objects[i];
			this.update(objects[i]);

			if (obj.body != null) {
				obj.body.update(this.lastUpdateEvent);
			}

			if (obj.movement != null) {
				obj.movement.update(this.lastUpdateEvent);
			}

			this.handleComponents(objects[i].components);
			this.handleComponents(objects[i].actions);
		}
	}

	public void add(GameObject obj) {
		if (obj instanceof Updateable) {
			super.add(obj);
		}
	}

	private void handleComponents(BaseComponent obj) {
		if (obj instanceof ComponentList) {
			for (BaseComponent comp : ((ComponentList<BaseComponent>) obj).getComponents()) {
				this.handleComponents(comp);
			}
		}

		this.update(obj);
	}

	private void update(BaseObject obj) {
		if (obj instanceof Updateable) {
			((Updateable) obj).update(this.lastUpdateEvent);
		}
	}
}
