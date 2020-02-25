package core.objects.components.movement;

import math.Angle;
import math.Coord;

public class AdvancedMovement extends SimpleMovement {
	protected Angle rotation = new Angle();
	protected double turnSpeed = 10;

	public AdvancedMovement() { }

	public AdvancedMovement(Coord c) {
		super(c);
	}

	public AdvancedMovement(Coord c, double baseSpeed) {
		super(c);
		this.setBaseSpeed(baseSpeed);
	}

// Actions

	public void start() {
		this.movement.setMagnitude(this.getBaseSpeed());
		this.setState(1);
	}

	public void stop() {
		this.movement.setMagnitude(0);
		this.setState(0);
	}

// Base speed

	public void setBaseSpeed(double baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public double getBaseSpeed() {
		return this.baseSpeed;
	}

// Direction

	public void setDirection(Angle a) {
		this.movement.setDirection(a);
	}

	public void setDirection(double a) {
		this.movement.setDirection(a);
	}

	public void setDirection(Coord c) {
		c = new Coord(c);
		c.sub(this.getPosition());
		this.movement.setDirection(c);
	}

	public double getDirection() {
		return this.movement.getDirection();
	}

// State

	protected void setState(int st) {
		this.movementState = st;
	}

	protected int getState() {
		return this.movementState;
	}

	public boolean isMoving() {
		return this.getState() != 0;
	}
}