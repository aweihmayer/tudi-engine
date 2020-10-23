package gameObjects.components.movement;

import gameObjects.components.body.Body;
import math.Angle;
import math.Coord;

public class SimpleMovement extends BaseMovement {
	protected double speed = 0;

	public SimpleMovement() { }

	public SimpleMovement(double speed) {
		this.setSpeed(speed);
	}

	public SimpleMovement(Body body, double speed) {
		super(body);
		this.setSpeed(speed);
	}

// Actions

	public void start() {
		this.force.setMagnitude(this.getSpeed());
	}

	public void stop() {
		this.force.setMagnitude(0);
	}

// Speed
	
	public void setSpeed(double baseSpeed) {
		this.speed = baseSpeed;
	}
	
	public double getSpeed() {
		return this.speed;
	}

// Direction

	public void setDirection(double a) {
		this.force.rotateTo(new Angle(a));
	}

	public void setDirection(Angle a) {
		this.force.rotateTo(a);
	}

	public void setDirection(Coord c) {
		c.sub(this.getBody().getPosition());
		this.force.setHead(c);
	}
}