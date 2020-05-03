package math.geometry;

public class Circle extends OneDimensionalShape {
	public Circle() {
		super(1);
	}

	public Circle(double w) {
		super(w);
	}

	public Circle clone() {
		return new Circle(this.getWidth());
	}

	public double getRadius() {
		return this.getWidth() / 2;
	}
}
