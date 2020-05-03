package core.objects.main.projectiles;

import core.objects.Collideable;
import core.objects.Drawable;
import core.objects.Updateable;
import core.objects.components.movement.BaseMovement;
import core.objects.main.SimpleBodyObject;

public abstract class BaseProjectile extends SimpleBodyObject implements Drawable, Updateable, Collideable {
	public BaseProjectile(BaseMovement movement) {
		super(movement.getBody());

		this.movement = movement;
	}

	public BaseProjectile clone() {
		BaseProjectile clone = (BaseProjectile) super.clone();
		clone.movement = this.movement;

		return clone;
	}
}
