package core.registry;

import core.Game;
import core.objects.main.GameObject;

public class ObjectRegistry {
	private static GameRegistryList registry = 	new GameRegistryList();

	private static final int OBJECT_NOT_ADDED_TO_REGISTRY_STATUS_CODE = 0;
	private static final int OBJECT_ADDED_TO_REGISTRY_STATUS_CODE = 1;
	private static final int OBJECT_REMOVE_FROM_REGISTRY_STATUS_CODE = -1;

// Add

	public static void add(GameObject obj) {
		registry.add(obj);

		Game.updateHandler.add(obj);
		Game.drawHandler.add(obj);
		Game.collisionHandler.add(obj);

		obj.setRegistryStatus(1);
	}

// Remove

	public static void remove(GameObject obj) {
		obj.setRegistryStatus(OBJECT_REMOVE_FROM_REGISTRY_STATUS_CODE);
	}

	public static void clear() {
		registry.clear();
		Game.updateHandler.clear();
		Game.drawHandler.clear();
		Game.collisionHandler.clear();
	}
}
