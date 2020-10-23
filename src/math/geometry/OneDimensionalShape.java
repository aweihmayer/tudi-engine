package math.geometry;

import math.ScalableNumber;

public abstract class OneDimensionalShape {
	protected ScalableNumber width = new ScalableNumber(1);

	public OneDimensionalShape() { }

	public OneDimensionalShape(double w) {
		this.setWidth(w);
	}

// Dimension

	public double getScaledWidth() {
		return this.width.getScaledValue();
	}

	public void setWidth(double w) {
		this.width.setValue(w);
	}

	public double getWidth() {
		return this.width.getValue();
	}

// Scale

	public void setWidthScale(double sc) {
		this.width.setScale(sc);
	}

	public double getWidthScale() {
		return this.width.getScale();
	}

	public void setScale(double sc) {
		this.width.setScale(sc);
	}
}
