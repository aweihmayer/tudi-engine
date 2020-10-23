package math.geometry;

import math.ScalableNumber;

public abstract class TwoDimensionalShape extends OneDimensionalShape {
	protected ScalableNumber height = new ScalableNumber(1);

	public TwoDimensionalShape(double sz) {
		super(sz);
		this.setHeight(sz);
	}

	public TwoDimensionalShape(double w, double h) {
		super(w);
		this.setHeight(h);
	}

// Dimensions

	public double getScaledHeight() {
		return this.height.getScaledValue();
	}

	public void setHeight(double h) {
		this.height.setValue(h);
	}

	public double getHeight() {
		return this.height.getValue();
	}

// Scale

	public void setHeightScale(double sc) {
		this.height.setScale(sc);
	}

	public double getHeightScale() {
		return this.height.getScale();
	}

	public void setScale(double sc) {
		super.setScale(sc);
		this.height.setScale(sc);
	}
}
