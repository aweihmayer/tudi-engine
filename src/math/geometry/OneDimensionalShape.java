package math.geometry;

import math.ScalableNumber;

public abstract class OneDimensionalShape {
	protected ScalableNumber width = new ScalableNumber(1);

	public OneDimensionalShape() { }

	public OneDimensionalShape(double w) {
		this.setBaseWidth(w);
	}

// Dimension

	public void setWidth(double w) {
		this.setBaseWidth(w);
		this.setWidthScale(1);
	}

	public void setBaseWidth(double w) {
		this.width.setBaseValue(w);
	}

	public double getWidth() {
		return this.width.getValue();
	}

	public double getBaseWidth() {
		return this.width.getBaseValue();
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
