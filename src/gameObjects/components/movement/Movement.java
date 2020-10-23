package gameObjects.components.movement;

import gameObjects.Updateable;
import math.Angle;
import math.Coord;

public interface Movement extends Updateable {
	public void start();

	public void stop();

	public void setDirection(double a);

	public void setDirection(Angle a);

	public void setDirection(Coord c);
}
