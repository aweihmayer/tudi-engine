package core.objects.main.projectiles;

import core.objects.components.movement.SimpleMovement;
import core.objects.main.SimpleBodyObject;
import core.objects.Collideable;
import core.objects.Drawable;
import core.objects.Updateable;
import core.objects.components.shape.BaseShape;
import math.Coord;

public abstract class BaseProjectile extends SimpleBodyObject implements Drawable, Updateable, Collideable {
	public BaseProjectile(Coord position, BaseShape graphic, BaseShape hitbox, double speed) {
		super(position, graphic, hitbox, speed);
		SimpleMovement mv = (SimpleMovement) this.components.getComponent(SimpleMovement.class);
		mv.start();
	}
}
