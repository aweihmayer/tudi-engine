package gameObjects.components.body.graphics;

import math.Angle;
import math.geometry.Circle;
import math.Coord;

import java.awt.*;

public class CircleGraphic extends Circle implements Graphic {
	public CircleGraphic() {
		super();
	}

	public CircleGraphic(double w) {
		super(w);
	}

	public CircleGraphic clone() {
		return new CircleGraphic(this.getWidth());
	}

	public void draw(Graphics2D g, Coord pos, Angle rot) {
		double x = pos.getX();
		double y = pos.getY();

		double r = this.getScaledWidth();
		x = (int) (x - (r / 2));
		y = (int) (y - (r /2));

		g.fillOval(
			(int) x, (int) y,
			(int) r, (int) r);
	}
}
