package core.objects.components.shape.hitboxes;

import core.objects.components.shape.Rectangle;

public class RectangleHitbox extends Rectangle implements Hitbox {
	public boolean checkCollision(CircleHitbox circ) {
		return true;
	}

	public boolean checkCollision(RectangleHitbox rect) {
		return true;
	}
}