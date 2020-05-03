package math;

public class Interval extends Number {
	protected double min = 0;
	protected double max = 0;

	public Interval(double v, double min, double max) {
		super(v);
		this.setMin(min);
		this.setMax(max);
	}

	public Interval clone() {
		return new Interval(this.getValue(), this.getMin(), this.getMax());
	}

// Value

	public void setValue(double v) {
		double min = this.getMin();
		double max = this.getMax();

		if(v < min) {
			v = min;
		} else if(v > max) {
			v = max;
		}

		super.setValue(v);
	}

	public double random() {
		return Number.random(this.getMin(), this.getMax());
	}

// Min

	public void setMin(double min) {
		this.min = min;
	}

	public double getMin() {
		return this.min;
	}


// Max

	public void setMax(double max) {
		this.max = max;
	}

	public double getMax() {
		return this.max;
	}
}
