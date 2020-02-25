package core.objects.components.shape;

public class Circle extends OneDimensionalShape {
	public Circle() {
		super(1);
	}

	public Circle(double w) {
		super(w);
	}

	public double getRadius() {
		return this.getWidth() / 2;
	}
}
