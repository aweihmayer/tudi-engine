package gameObjects.components.body.hitboxes;

import math.Angle;
import math.Coord;
import math.geometry.Circle;

public class CircleHitbox extends Circle implements Hitbox {
	public CircleHitbox() {
		super();
	}

	public CircleHitbox(double size) {
		super(size);
	}

	public CircleHitbox clone() {
		return new CircleHitbox(this.getWidth());
	}

	public boolean checkCollision(Coord position1, Angle rotation1, CircleHitbox circ, Coord position2, Angle rotation2) {
		double radiusTotal = this.getRadius() + circ.getRadius();
		double distanceFromRadius = position1.distanceFrom(position2);
		return distanceFromRadius < radiusTotal;
	}

	public boolean checkCollision(Coord position1, Angle rotation1, RectangleHitbox rect, Coord position2, Angle rotation2) {
		return true;
	}
}
