package math;

public class Coord {
	protected double x = 0;
	protected double y = 0;

	public Coord() { }

	public Coord(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public Coord(Angle a, double length) {
		this();

		Double v = a.getValueInRadians();
		this.setX(Math.cos(v) * length);
		this.setY(Math.sin(v) * length);
	}

	public Coord clone() {
		return new Coord(this.getX(), this.getY());
	}
	
// Position

	public void set(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return this.x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return this.y;
	}

	public void add(Coord c) {
		this.x += c.getX();
		this.y += c.getY();
	}
	
	public void sub(Coord c) {
		this.x -= c.getX();
		this.y -= c.getY();
	}
	
	public double distanceFrom(Coord c) {
		c = c.clone();
		c.sub(this);
		double x = c.getX();
		double y = c.getY();
		
		return Math.sqrt((x * x) + (y * y));
	}

// Transform

	public void rotateTo(Angle angle) {
		double rad = angle.getValueInRadians();

		this.set(
			this.getX() * Math.cos(rad) - y * Math.sin(rad),
			this.getY() * Math.cos(rad) + x * Math.sin(rad));
	}

	public void rotateBy() {
		/*x′=xcosθ−ysinθ
		y′=ycosθ+xsinθ
		Where θ is the angle of rotation*/
	}
}
