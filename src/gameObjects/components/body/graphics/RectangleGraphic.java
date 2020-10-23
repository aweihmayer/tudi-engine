package gameObjects.components.body.graphics;

import math.Angle;
import math.geometry.Rectangle;
import math.Coord;

import java.awt.*;

public class RectangleGraphic extends Rectangle implements Graphic {
	public RectangleGraphic() {
		super();
	}

	public RectangleGraphic(double w, double h) {
		super(w, h);
	}

	public RectangleGraphic clone() {
		return new RectangleGraphic(this.getWidth(), this.getHeight());
	}

	public void draw(Graphics2D g, Coord pos, Angle rot) {
		double x = pos.getX();
		double y = pos.getY();

		double w = this.getWidth();
		double h = this.getHeight();
		x = (int) (x - (w / 2));
		y = (int) (y - (h /2));

		g.drawRect(
				(int) x, (int) y,
				(int) w, (int) h);
	}
}
