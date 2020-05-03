package math.geometry;

public class Square extends OneDimensionalShape {
	public Square() {
		super(1);
	}

	public Square(double w) {
		super(w);
	}

	public Square clone() {
		return new Square(this.getWidth());
	}
}
