package math;

public class Coord {
	protected double x = 0;
	protected double y = 0;

	public Coord() { }
	
	public Coord(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Coord(Coord c) {
		this(c.getX(), c.getY());
	}
	
// Position
	
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
		c = new Coord(c);
		c.sub(this);
		double x = c.getX();
		double y = c.getY();
		
		return Math.sqrt((x * x) + (y * y));
	}
}
