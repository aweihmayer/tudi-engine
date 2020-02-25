package core.registry;

import java.util.ArrayList;

public class GameRegistryList<T> {
	private ArrayList<T> list = 					new ArrayList<T>();
	private ArrayList<Integer> availableIndexes = 	new ArrayList<Integer>();

	public int add(T item) {
		int i;

		if(!this.availableIndexes.isEmpty()) {
			i = availableIndexes.remove(0);
			this.list.set(i, item);
		} else {
			i = this.list.size();
			this.list.add(item);
		}

		return i;
	}

	public int size() {
		return this.list.size();
	}

	public T get(int i) {
		return this.list.get(i);
	}

	public void clear() {
		this.list.clear();
		this.availableIndexes.clear();
	}

	public void remove(int i) {
		this.availableIndexes.add(i);
		this.list.set(i, null);
	}
}
