package gameObjects.components;

import gameObjects.BaseObject;

public abstract class BaseComponent extends BaseObject {
	protected BaseObject parent;

// Parent

	public void setParent(BaseObject p) {
		this.parent = p;
	}

	public BaseObject getParent() {
		return this.parent;
	}

	public BaseObject getParent(int depth) {
		BaseObject p = this.getParent();

		if (p instanceof BaseComponent) {
			BaseComponent p2 = (BaseComponent) p;
			int count = 1;

			while (count < depth && p2.hasParent()) {
				p = p2.getParent();

				if(p instanceof BaseComponent) {
					p2 = (BaseComponent) p;
				} else {
					break;
				}

				count++;
			}
		}

		return p;
	}

	public BaseObject getTopParent() {
		return this.getParent(999);
	}

	public boolean hasParent() {
		return this.getParent() != null;
	}
}