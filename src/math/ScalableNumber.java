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

// Value

	protected void refreshValue() {
		double value = this.getBaseValue() * this.getScale();
		this.setValue(value);
	}

// Base value
	
	public void setBaseValue(double baseValue) {
		this.baseValue = baseValue;
		this.refreshValue();
	}
	
	public double getBaseValue() {
		return this.baseValue;
	}
	
// Scale
	
	public void setScale(double scale) {
		this.scale = scale;
		this.refreshValue();
	}
	
	public double getScale() {
		return this.scale;
	}
}
