package core.objects.components.body.hitboxes;

import math.Angle;
import math.Coord;
import math.geometry.Rectangle;

public class RectangleHitbox extends Rectangle implements Hitbox {
	public RectangleHitbox() {
		super();
	}

	public RectangleHitbox(double w, double h) {
		super(w, h);
	}

	public RectangleHitbox clone() {
		return new RectangleHitbox(this.getWidth(), this.getHeight());
	}

	public boolean checkCollision(Coord position1, Angle rotation1, CircleHitbox circ, Coord position2, Angle rotation2) {
		return true;
	}

	public boolean checkCollision(Coord position1, Angle rotation1, RectangleHitbox rect, Coord position2, Angle rotation2) {
		return true;
	}
}