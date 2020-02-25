package math;

public class Angle extends Number {
	public Angle() { }
	
	public Angle(Angle a) {
		this(a.getValue());
	}

	public Angle(Number n) {
		this(n.getValue());
	}
	
	public Angle(double v) {
		this.setValue(v);
	}
	
// Value
	
	public void setValue(double n) {
		if(n > 360){
			n = this.getValue() % 360;
		} else if(n < 0){
			n = 360 - this.getValue();
		}
		
		super.setValue(n);
	}
	
	public double getValueInRadians() {
		return Math.toRadians(this.getValue());
	}

	public static Angle angleBetween(Coord c1, Coord c2) {
		c2 = new Coord(c2);
		c2.sub(c1);
		double a = Math.atan2(c2.getY(), c2.getX());
		a = Math.toDegrees(a);
		
	    if(a < 0){
	        a += 360;
	    }
		
		return new Angle(a);
	}
}
