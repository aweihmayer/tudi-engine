package math;

public class Vector {
	protected Number magnitude = new Number();
	protected Angle direction = new Angle();

	public Vector() { }
	
	public Vector(Vector v) {
		this(v.getMagnitude(), v.getDirection());
	}
	
	public Vector(double mag) {
		this(mag, 0);
	}
	
	public Vector(double mag, Angle a) {
		this(mag, a.getValue());
	}
	
	public Vector(double mag, double a) {
		this.setMagnitude(mag);
		this.setDirection(a);
	}
	
// Magnitude
	
	public void setMagnitude(double mag) {
		this.magnitude.setValue(mag);
	}
	
	public double getMagnitude() {
		return this.magnitude.getValue();
	}

	public void addMagnitude(double mag) {
		this.magnitude.add(mag);
	}

// Min

	public void setMinMagnitude(double min) {
		this.magnitude.setMin(min);
	}

	public double getMinMagnitude() {
		return this.magnitude.getMin();
	}

	public void enableMinMagnitude() {
		this.magnitude.enableMin();
	}

	public void disableMinMagnitude() {
		this.magnitude.disableMin();
	}

	public boolean isMinMagnitudeEnabled() {
		return this.magnitude.isMinEnabled();
	}

// Max

	public void setMaxMagnitude(double max) {
		this.magnitude.setMax(max);
	}

	public double getMaxMagnitude() {
		return this.magnitude.getMax();
	}

	public void enableMaxMagnitude() {
		this.magnitude.enableMax();
	}

	public void disableMaxMagnitude() {
		this.magnitude.disableMax();
	}

	public boolean isMaxMagnitudeEnabled() {
		return this.magnitude.isMaxEnabled();
	}

// Direction
	
	public void setDirection(double a) {
		this.direction.setValue(a);
	}
	
	public void setDirection(Angle a) {
		this.direction = a;
	}
	
	public void setDirection(Coord c) {
		double a = Math.atan2(c.getY(), c.getX());
		a = Math.toDegrees(a);
		
	    if(a < 0) {
	        a += 360;
	    }
		
		this.setDirection(a);
	}
	
	public double getDirection() {
		return this.direction.getValue();
	}
	
	public double getDirectionInRadians() {
		return this.direction.getValueInRadians();
	}

// Head
	
	public Coord getHead() {
		Double a = this.getDirectionInRadians();
		Double mag = this.getMagnitude();
		return new Coord(Math.cos(a) * mag, Math.sin(a) * mag);
	}
}
