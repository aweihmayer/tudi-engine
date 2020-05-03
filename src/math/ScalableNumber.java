package math;

public class ScalableNumber extends Number {
	protected double baseValue = 1;
	protected double scale = 1;

	public ScalableNumber() {
		this(1, 1);
	}
	
	public ScalableNumber(double baseValue) {
		this(baseValue, 1);
	}
	
	public ScalableNumber(double baseValue, double scale) {
		this.setBaseValue(baseValue);
		this.setScale(scale);
	}

	public ScalableNumber clone() {
		return new ScalableNumber(this.getBaseValue(), this.getScale());
	}

// Base value
	
	public void setBaseValue(double baseValue) {
		this.baseValue = baseValue;
	}
	
	public double getBaseValue() {
		return this.getValue() * this.getScale();
	}
	
// Scale
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	public double getScale() {
		return this.scale;
	}
}
