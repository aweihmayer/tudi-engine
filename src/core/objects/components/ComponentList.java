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

	public <A> List<A> getComponents2(Class<A> cls, int depth) {
		List<A> components = new ArrayList();
		A obj;

		for (T comp : this.components) {
			if (cls.isInstance(comp)) {
				obj = cls.cast(comp);
				components.add(obj);

				if (depth == 0) {
					break;
				}
			} else if (comp instanceof ComponentList && depth == 2) {
				components.addAll(((ComponentList<BaseComponent>) comp).getComponents2(cls, depth));
			}
		}

		return components;
	}

// Has

	public boolean hasComponent(Class<?> cls) {
		return this.getComponent(cls) != null;
	}
}
