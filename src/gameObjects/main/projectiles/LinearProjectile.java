package gameObjects.main.projectiles;

import gameObjects.components.body.Body;
import gameObjects.components.body.graphics.Graphic;
import gameObjects.components.body.hitboxes.Hitbox;
import gameObjects.components.movement.SimpleMovement;
import math.Coord;

public abstract class LinearProjectile extends BaseProjectile {
	public LinearProjectile(
		Coord position, Coord target,
		Graphic graphic, Hitbox hitbox,
		double speed) {

		super(new SimpleMovement(
				new Body(position, graphic, hitbox),
				speed));

		SimpleMovement movement = (SimpleMovement) this.components.getComponent(SimpleMovement.class);
		movement.setDirection(target);
	}
}