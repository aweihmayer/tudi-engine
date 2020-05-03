package core.objects.components.movement;

import core.objects.Updateable;
import math.Coord;

public interface Movement extends Updateable {
	public void start();

	public void stop();

	public void setDirection(Coord c);
}
