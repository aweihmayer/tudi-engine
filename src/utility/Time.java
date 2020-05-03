package utility;

public class Time {
	public long time = 0;

	public Time() {
		this.setTimeToNow();
	}

	public Time(long offset) {
		this.setTimeToNow(offset);
	}

	public Time clone() {
		Time time = new Time();
		time.setTime(this.getTime());
		return time;
	}

// Time

	public void setTime(long time) {
		this.time = time;
	}

	public void setTimeToNow() {
		this.time = now();
	}

	public void setTimeToNow(long offset) {
		this.setTime(this.getTime() + offset);
	}

	public long getTime() {
		return this.time;
	}

	public boolean isLaterThanNow() {
		return this.getTime() > now();
	}

	public void add(long time) {
		this.setTime(this.getTime() + time);
	}

	public long diffFromNow(){
		return now() - this.getTime();
	}

	public long diff(long time) {
		return this.getTime() - time;
	}

	public static long now(){
		return System.currentTimeMillis();
	}
}