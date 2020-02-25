package core.objects.components.shape.graphics;

import core.objects.Drawable;
import core.objects.components.shape.Circle;
import math.Coord;

import java.awt.*;

public class CircleGraphic extends Circle implements Drawable {
	public void draw(Graphics2D g) {
		Coord c = this.getPosition();
		double x = c.getX();
		double y = c.getY();

		double r = this.getWidth();
		x = (int) (x - (r / 2));
		y = (int) (y - (r /2));

		g.fillOval(
			(int) x, (int) y,
			(int) r, (int) r);
	}
}
