package math.physics;

import java.util.ArrayList;
import java.util.List;

public class Forces {
	protected List<Force> forces = new ArrayList<Force>();

	public void addForce(Force f) {
		this.forces.add(f);
	}

	public Force getResultingForce() {
		Force force = new Force();

		for (int i = 0; i < this.forces.size(); i++) {
			force.add(this.forces.get(i));
		}

		return force;
	}

	public void clear() {
		this.forces.clear();
	}

	public void removeExpiredForces() {
		for (int i = 0; i < this.forces.size(); i++) {
			if (this.forces.get(i).isExpired()) {
				this.forces.remove(i);
			}
		}
	}
}
