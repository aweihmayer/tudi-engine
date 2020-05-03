package core.objects.components.actions.shoot;

import core.objects.components.actions.BaseAction;
import core.objects.main.projectiles.BaseProjectile;
import core.registry.ObjectRegistry;
import math.Coord;

public abstract class BaseShootAction extends BaseAction {
	protected Coord positionOrigin;
	protected Coord target;
	protected BaseProjectile projectToLaunch;

	public BaseShootAction() { }

	public void setPositionOrigin(Coord target) {
		this.target = positionOrigin;
	}

	public Coord getPositionOrigin() {
		return this.positionOrigin;
	}

	public void setTarget(Coord target) {
		this.target = target;
	}

	public Coord getTarget() {
		return this.target;
	}

	protected void launchProjectile() {
		Coord target = this.getTarget();
		target.sub(this.getPositionOrigin());

		this.projectToLaunch.movement.setDirection(target);
		ObjectRegistry.add(this.projectToLaunch);
	}
}
