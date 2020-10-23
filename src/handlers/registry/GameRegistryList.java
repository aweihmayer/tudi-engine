package handlers.registry;

import gameObjects.main.GameObject;

import java.util.ArrayList;
import java.util.List;

public class GameRegistryList {
	private ArrayList<GameObject> list = 			new ArrayList<GameObject>();
	private ArrayList<Integer> availableIndexes = 	new ArrayList<Integer>();

	public int add(GameObject item) {
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

	public GameObject get(int i) {
		return this.list.get(i);
	}

	public void clear() {
		this.list.clear();
		this.availableIndexes.clear();
	}

	public void clean() {
		GameObject obj;

		for (int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i) != null
			&& this.list.get(i).registryStatus == ObjectRegistry.OBJECT_REMOVE_FROM_REGISTRY_STATUS_CODE) {
				this.remove(i);
			}
		}
	}

	public void remove(int i) {
		this.availableIndexes.add(i);
		this.list.set(i, null);
	}

	public GameObject[] toArray() {
		List<GameObject> objects = new ArrayList<GameObject>();

		for (int i = 0; i < list.size(); i++) {
			if(this.list.get(i) != null) {
				objects.add(this.list.get(i));
			}
		}

		return objects.toArray(
			new GameObject[
					objects.size()]);
	}
}
