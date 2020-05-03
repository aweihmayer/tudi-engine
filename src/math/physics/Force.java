package math.physics;

import math.Coord;
import utility.Time;

public class Force extends Vector {
	protected Time expiration;

	public Force() {
		this(new Coord());
	}

	public Force(Coord head) {
		this(head, new Time());
	}

	public Force(Coord head, Time expiration) {
		this.setHead(head);
		this.setExpiration(expiration);
	}

	public Force clone() {
		return new Force(this.getHead().clone(), this.getExpiration().clone());
	}

	public boolean isExpired() {
		return !this.getExpiration().isLaterThanNow();
	}

	public void setExpiration(Time time) {
		this.expiration = time;
	}

	public Time getExpiration() {
		return this.expiration;
	}
}
