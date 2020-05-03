package core.objects.components.movement;

import core.objects.components.BaseComponent;
import core.events.UpdateEvent;
import core.objects.Updateable;
import core.objects.components.body.Body;
import math.physics.Force;
import utility.Time;

public abstract class BaseMovement extends BaseComponent implements Movement {
	protected Body body;
	protected Force force = new Force();

	public BaseMovement() { }

	public BaseMovement(Body body) {
		this.body = body;
	}

// Body

	public void setBody(Body body) {
		this.body = body;
	}

	public Body getBody() {
		return this.body;
	}

// Events

	public void update(UpdateEvent ev) {
		Force force = this.force.clone();
		force.setExpiration(new Time());

		this.body.getForces().addForce(force);
	}
}