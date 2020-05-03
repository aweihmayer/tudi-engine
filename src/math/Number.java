package math;

public class Number {
	protected double value = 0;

	public Number() { }

	public Number(double n) {
		this.setValue(n);
	}

	public Number clone() {
		return new Number(this.getValue());
	}
	
// Value
	
	public void setValue(double v) {
		this.value = v;
	}
	
	public double getValue() {
		return this.value;
	}

	public void add(double v) {
		this.setValue(this.getValue() + v);
	}

	public void sub(double v) {
		this.setValue(this.getValue() - v);
	}

	public void multiply(double v) {
		this.setValue(this.getValue() * v);
	}

	public void divide(double v) {
		this.setValue(this.getValue() / v);
	}

	public void round() {
		this.setValue(Math.round(this.getValue()));
	}

	public void ceil() {
		this.setValue(Math.ceil(this.getValue()));
	}

	public void floor() {
		this.setValue(Math.floor(this.getValue()));
	}

	public static double random(double min, double max) {
		return Math.random() * ((max - min) + 1) + min;
	}
}
