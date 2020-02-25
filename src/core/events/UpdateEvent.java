package core.events;

public class UpdateEvent {
	private long timestamp = 0;
	private long timeSinceLastUpdate = 0;
	private double fractionOfSecond = 0;

	public UpdateEvent() {
		this.timestamp = System.nanoTime();
	}

	public UpdateEvent(UpdateEvent ev) {
		this.timestamp = System.nanoTime();
		this.timeSinceLastUpdate = this.timestamp - ev.getTimestamp();
		this.fractionOfSecond = (double)((float) this.timeSinceLastUpdate / (float) 1000000000);
	}
	
// Time
	
	public long getTimestamp() {
		return this.timestamp;
	}
	
	public long getTimeSinceLastUpdate() {
		return this.timeSinceLastUpdate;
	}
	
	public double getFractionOfSecond() {
		return this.fractionOfSecond;
	}
}
