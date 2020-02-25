package core.objects.components.shape;

import math.ScalableNumber;

public abstract class TwoDimensionalShape extends OneDimensionalShape {
	protected ScalableNumber height = new ScalableNumber(1);

	public TwoDimensionalShape(double sz) {
		super(sz);
		this.setBaseHeight(sz);
	}

	public TwoDimensionalShape(double w, double h) {
		super(w);
		this.setBaseHeight(h);
	}

// Dimensions

	public void setHeight(double h) {
		this.setBaseHeight(h);
		this.setWidthScale(1);
	}

	public double getHeight() {
		return this.height.getValue();
	}

// Base dimensions

	public void setBaseHeight(double h) {
		this.height.setBaseValue(h);
	}

	public double getBaseHeight() {
		return this.height.getBaseValue();
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
