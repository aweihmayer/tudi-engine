package gameObjects.components.movement;

import gameObjects.components.BaseComponent;
import handlers.events.UpdateEvent;
import gameObjects.components.body.Body;
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