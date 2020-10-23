package gameObjects.components.actions.shoot;

import handlers.registry.ObjectRegistry;
import math.Angle;
import math.Coord;
import math.Number;

public abstract class SingleShotAction extends BaseShootAction {
	public void perform() {
		this.launchProjectile();
		Angle bulletDirection;
/*
		Coord target = this.getTarget();
		target.sub(this.getPositionOrigin());

		for (int i = 0; i < this.numberOfBulletsPerShot; i++) {
			bulletDirection = new Angle(straightDirection);
			bulletDirection.add(Number.random(-11, 11));
			bullet = new Bullet(new Coord(playerPosition), bulletDirection);
			ObjectRegistry.add(bullet);
		}*/
	}
}
