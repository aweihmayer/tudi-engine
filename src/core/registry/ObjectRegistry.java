package core.registry;

import core.Game;
import core.objects.main.GameObject;

import java.util.List;
import java.util.ArrayList;

public class ObjectRegistry {
	private static GameRegistryList<GameObject> registry = 	new GameRegistryList<GameObject>();

// Add

	public static void add(GameObject obj) {
		int i = registry.add(obj);

		Game.updateHandler.add(obj);
		Game.drawHandler.add(obj);
		Game.collisionHandler.add(obj);
	}

// Remove

	public static void remove(GameObject obj) {
		obj.setRegistryIndex(-2);
		int i = obj.getRegistryIndex();
		registry.remove(i);

		Game.updateHandler.remove(obj);
		Game.drawHandler.remove(obj);
		Game.collisionHandler.remove(obj);
	}

	public static void clear() {
		registry.clear();

		Game.updateHandler.clear();
		Game.drawHandler.clear();
		Game.collisionHandler.clear();
	}

// Retrieve

	public static GameObject get(int i) {
		GameObject obj = null;

		if(registry.get(i) != null) {
			obj = registry.get(i);
		}
		
		return obj;
	}

	public static GameObject[] getWithReferenceList(GameRegistryList<Integer> list) {
		int refI;
		GameObject obj;
		List<GameObject> objects = new ArrayList<GameObject>();

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
				obj = get(list.get(i));

				if(obj != null) {
					objects.add(obj);
				}
			}
		}

		return objects.toArray(
			new GameObject[
				objects.size()]);
	}
}
