package core.handlers;

import core.registry.GameRegistryList;
import core.registry.ObjectRegistry;
import core.objects.BaseObject;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;
import core.objects.main.GameObject;
import core.events.UpdateEvent;
import core.objects.Updateable;

public class UpdateHandler implements Handler {
	private GameRegistryList<Integer> ref =	new GameRegistryList<Integer>();
	private UpdateEvent lastUpdateEvent = new UpdateEvent();

	public void add(GameObject obj) {
		int i = this.ref.add(obj.getRegistryIndex());
		obj.setUpdateHandlerIndex(i);
	}

	public void remove(GameObject obj) {
		this.ref.remove(obj.getUpdateHandlerIndex());
	}

	public void clear() {
		this.ref.clear();
	}

	public void handle() {
		GameObject[] objects = ObjectRegistry.getWithReferenceList(this.ref);
		this.lastUpdateEvent = new UpdateEvent(this.lastUpdateEvent);

		for(int i = 0; i < objects.length; i++) {
			this.update(objects[i]);
			this.handleComponents(objects[i].components);
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
