package core.objects.components.movement;

import core.objects.components.BaseComponent;
import core.events.UpdateEvent;
import core.objects.Updateable;
import math.Vector;
import math.Coord;

public class BaseMovement extends BaseComponent implements Updateable {
	protected Coord position = new Coord();

	protected Vector movement = new Vector();

	public BaseMovement() { }

	public BaseMovement(Coord c) {
		this.setPosition(c);
	}

// Events

	public void update(UpdateEvent ev) {
		this.applyMovement(ev);
	}

	protected void applyMovement(UpdateEvent ev) {
		Coord movement = this.movement.getHead();

		movement.setX(
			movement.getX() * ev.getFractionOfSecond());
		movement.setY(
			movement.getY() * ev.getFractionOfSecond());

		this.getPosition().add(movement);
	}

// Position

	public void setPosition(Coord c) {
		this.position = c;
	}

	public Coord getPosition() {
		return this.position;
	}

	public Coord getCurrentPosition() {
		return new Coord(this.getPosition());
	}
}