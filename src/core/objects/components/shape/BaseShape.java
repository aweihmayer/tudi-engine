package core.objects.components.shape;

import core.objects.components.BaseComponent;
import math.Angle;
import math.Coord;

public abstract class BaseShape extends BaseComponent {
	protected Coord position = new Coord();
	protected Angle rotation = new Angle();

// Position

	public void setPosition(Coord c) {		this.position = c;						}

	public Coord getPosition() {			return this.position;					}

	public Coord getCurrentPosition() {		return new Coord(this.getPosition());	}

// Rotation

	public void setRotation(Angle a) {		this.rotation = a;						}

	public void setRotation(double a) {		this.rotation.setValue(a);				}

	public Angle getRotation() {			return this.rotation;					}
}
