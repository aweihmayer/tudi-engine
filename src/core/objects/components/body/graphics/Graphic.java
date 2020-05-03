package core.objects.components.body.graphics;

import math.Angle;
import math.Coord;

import java.awt.*;

public interface Graphic {
	public Graphic clone();

	public void draw(Graphics2D g, Coord c, Angle a);
}
