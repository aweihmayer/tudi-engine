package gameObjects.main.projectiles;

import gameObjects.Collideable;
import gameObjects.Drawable;
import gameObjects.Updateable;
import gameObjects.components.movement.BaseMovement;
import gameObjects.main.SimpleBodyObject;

public abstract class BaseProjectile extends SimpleBodyObject implements Drawable, Updateable, Collideable {
	public BaseProjectile(BaseMovement movement) {
		super(movement.getBody());

		this.movement = movement;
	}
/*
	public BaseProjectile clone() {
		BaseProjectile clone = (BaseProjectile) super.clone();
		clone.movement = this.movement;

		return clone;
	}*/
}
