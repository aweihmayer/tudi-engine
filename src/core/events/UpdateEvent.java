package core.events;

import utility.Time;

public class UpdateEvent {
	private Time timestamp = new Time();
	private long timeSinceLastUpdate = 0;
	private double fractionOfSecond = 0;

	public UpdateEvent() {
		this.timestamp.setTime(System.nanoTime());
	}

	public UpdateEvent(UpdateEvent ev) {
		this.timestamp.setTime(System.nanoTime());
		this.timeSinceLastUpdate = this.timestamp.diff(ev.getTimestamp());
		this.fractionOfSecond = (double)((float) this.timeSinceLastUpdate / (float) 1000000000);
	}
	
// Time
	
	public long getTimestamp() {
		return this.timestamp.getTime();
	}
	
	public long getTimeSinceLastUpdate() {
		return this.timeSinceLastUpdate;
	}
	
	public double getFractionOfSecond() {
		return this.fractionOfSecond;
	}
}
