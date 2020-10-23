package gameObjects.components.body.hitboxes;

import math.Angle;
import math.Coord;

public interface Hitbox {
	public Hitbox clone();

	public boolean checkCollision(Coord position1, Angle rotation1,
  		CircleHitbox hitbox, Coord position2, Angle rotation2);

	public boolean checkCollision(Coord position1, Angle rotation1,
		RectangleHitbox rect, Coord position2, Angle rotation2);
}
