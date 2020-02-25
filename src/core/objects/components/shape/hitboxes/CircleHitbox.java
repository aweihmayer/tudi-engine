package core.objects.components.shape.hitboxes;

import core.objects.components.shape.Circle;

public class CircleHitbox extends Circle implements Hitbox {
	public boolean checkCollision(CircleHitbox circ) {
		double radiusTotal = this.getRadius() + circ.getRadius();
		double distanceFromRadius = this.getPosition().distanceFrom(circ.getPosition());
		return distanceFromRadius < radiusTotal;
	}

	public boolean checkCollision(RectangleHitbox rect) {
		return true;
	}
}
