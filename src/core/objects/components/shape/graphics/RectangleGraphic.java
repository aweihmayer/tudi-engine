package core.objects.components.shape.graphics;

import core.objects.Drawable;
import core.objects.components.shape.Rectangle;
import math.Coord;

import java.awt.*;

public class RectangleGraphic extends Rectangle implements Drawable {
	public void draw(Graphics2D g) {
		Coord c = this.getPosition();
		double x = c.getX();
		double y = c.getY();

		double w = this.getWidth();
		double h = this.getHeight();
		x = (int) (x - (w / 2));
		y = (int) (y - (h /2));

		g.drawRect(
				(int) x, (int) y,
				(int) w, (int) h);
	}
}
