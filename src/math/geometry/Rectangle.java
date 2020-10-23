package math.geometry;

import gameObjects.components.body.hitboxes.RectangleHitbox;

public class Rectangle extends TwoDimensionalShape {
	public Rectangle() {
		super(1, 1);
	}

	public Rectangle(double w, double h) {
		super(w, h);
	}

	public Rectangle clone() {
		return new Rectangle(this.getWidth(), this.getHeight());
	}
}
