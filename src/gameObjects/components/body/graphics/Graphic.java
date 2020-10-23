package gameObjects.components.body.graphics;

import math.Angle;
import math.Coord;

import java.awt.*;

public interface Graphic {
	public void draw(Graphics2D g, Coord c, Angle a);
}
