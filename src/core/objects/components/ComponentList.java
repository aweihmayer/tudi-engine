package core.objects.components;

import java.util.ArrayList;
import java.util.List;

public class ComponentList<T extends BaseComponent> extends BaseComponent {
	protected List<T> components = new ArrayList<T>();

	// Set

	public void setComponents(T[] components) {
		for(int i = 0; i < components.length; i++) {
			this.addComponent(components[i]);
		}
	}

	public void setComponents(ArrayList<T> components) {
		this.components = components;
	}

// Add

	public void addComponent(T comp) {
		comp.setParent(this);
		this.components.add(comp);
	}

// Remove

	public void removeComponent(Class<?> cls) {
		for (int i = 0; i < this.components.size(); i++) {
			if(cls.isInstance(this.components.get(i))) {
				this.components.remove(i);
			}
		}
	}

// Get

	public List<T> getComponents() {
		return this.components;
	}

	public List<T> getComponents(Class<?> cls) {
		List<T> components = new ArrayList<T>();

		for (T comp : this.components) {
			if (cls.isInstance(comp)) {
				components.add(comp);
			}
		}

		return components;
	}

	public T getComponent(Class<?> cls) {
		T component = null;

		for (T comp : this.components) {
			if (cls.isInstance(comp)) {
				component = comp;
				break;
			}
		}

		return component;
	}

// Has

	public boolean hasComponent(Class<?> cls) {
		return this.getComponent(cls) != null;
	}
}
