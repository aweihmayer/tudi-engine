package core.objects.main.projectiles;

import core.objects.components.body.Body;
import core.objects.components.body.graphics.Graphic;
import core.objects.components.body.hitboxes.Hitbox;
import core.objects.components.movement.SimpleMovement;
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