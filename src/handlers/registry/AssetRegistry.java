package handlers.registry;

import assets.sprite.SpriteSheet;

import java.util.HashMap;

public class AssetRegistry {
	private static HashMap<String, SpriteSheet> spriteSheets = new HashMap<String, SpriteSheet>();
	
// Sprite sheet

	public static void addSpriteSheet(SpriteSheet s) {
		spriteSheets.put(s.getName(), s);
	}

	public static SpriteSheet getSpriteSheet(String name) {
		return spriteSheets.get(name);
	}
}