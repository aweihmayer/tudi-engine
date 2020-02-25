package core.objects.main.projectiles;

import core.objects.components.movement.SimpleMovement;
import core.objects.components.shape.BaseShape;
import math.Angle;
import math.Coord;

public abstract class LinearProjectile extends BaseProjectile {
	public LinearProjectile(Coord position, Coord target, BaseShape graphic, BaseShape hitbox, double speed) {
		super(position, graphic, hitbox, speed);
		SimpleMovement mv = (SimpleMovement) this.components.getComponent(SimpleMovement.class);
		mv.setDirection(target);
	}
	
	public LinearProjectile(Coord position, Angle direction, BaseShape graphic, BaseShape hitbox, double speed) {
		super(position, graphic, hitbox, speed);
		SimpleMovement mv = (SimpleMovement) this.components.getComponent(SimpleMovement.class);
		mv.setDirection(direction);
	}
}