package math;

public class Number {
	protected double value = 0;

	protected boolean isMinEnabled = false;
	protected double min = 0;

	protected boolean isMaxEnabled = false;
	protected double max = 0;

	public Number() { }

	public Number(Number n) {
		this.setValue(n.getValue());
	}

	public Number(double n) {
		this.setValue(n);
	}

	public Number(double n, double min) {
		this.setValue(n);
		this.setMin(min);
	}

	public Number(double n, double min, double max) {
		this.setValue(n);
		this.setMin(min);
		this.setMax(max);
	}
	
// Value
	
	public void setValue(double n) {
		double min = this.getMin();
		double max = this.getMax();
	
		if(this.isMinEnabled() && n < min) {
			n = min;
		} else if(this.isMaxEnabled() && n > max) {
			n = max;
		}
		
		this.value = n;
	}
	
	public double getValue() {
		return this.value;
	}

	public void add(double n) {
		this.setValue(this.getValue() + n);
	}

	public void sub(double n) {
		this.setValue(this.getValue() - n);
	}

	public void multiply(double n) {
		this.setValue(this.getValue() * n);
	}

	public void divide(double n) {
		this.setValue(this.getValue() / n);
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

	public double random() {
		return random(this.getMin(), this.getMax());
	}

	public static double random(double min, double max) {
		return Math.random() * ((max - min) + 1) + min;
	}

// Min
	
	public void setMin(double min) {
		this.min = min;
		this.enableMin();
	}

	public double getMin() {
		return this.min;
	}
	
	public void enableMin() {
		this.isMinEnabled = true;
	}

	public void disableMin() {
		this.isMinEnabled = false;
	}
	
	public boolean isMinEnabled() {
		return this.isMinEnabled;
	}
	
// Max
	
	public void setMax(double max) {
		this.max = max;
		this.enableMax();
	}

	public double getMax() {
		return this.max;
	}

	public void enableMax() {
		this.isMaxEnabled = true;
	}

	public void disableMax() {
		this.isMaxEnabled = false;
	}
	
	public boolean isMaxEnabled() {
		return this.isMaxEnabled;
	}
}
