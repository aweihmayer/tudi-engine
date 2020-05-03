package core.handlers;

import core.objects.main.GameObject;
import core.registry.GameRegistryList;

public abstract class BaseHandler implements Handler {
	protected GameRegistryList ref =	new GameRegistryList();

	public void add(GameObject obj) {
		this.ref.add(obj);
	}

	public void clear() {
		this.ref.clear();
	}

	public void clean() {
		this.ref.clean();
	}
}
