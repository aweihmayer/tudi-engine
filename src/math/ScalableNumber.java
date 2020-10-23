package math;

public class ScalableNumber extends Number {
	protected double scale = 1;

	public ScalableNumber() {
		this(1, 1);
	}
	
	public ScalableNumber(double value) {
		this(value, 1);
	}
	
	public ScalableNumber(double value, double scale) {
		super(value);
		this.setScale(scale);
	}

	public ScalableNumber clone() {
		return new ScalableNumber(this.getValue(), this.getScale());
	}

// Value

	public double getScaledValue() {
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
