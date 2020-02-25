package core.registry;

import core.objects.components.shape.graphics.sprite.SpriteList;
import core.objects.components.shape.graphics.sprite.SpriteSheet;

public class AssetRegistry {
	protected static SpriteList spriteSheets = new SpriteList();
	
// Sprite sheet
	
	public static SpriteSheet getSpriteSheet(String name) {
		return spriteSheets.get(name);
	}

	public static void loadSpriteSheets(String p) {
		spriteSheets.load(p);
	}
}
