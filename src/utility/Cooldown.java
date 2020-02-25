package utility;

public class Cooldown {
	protected long cooldownDuration = 0;
	protected long cooldownTime = 0;

	public Cooldown() { }

	public Cooldown(long cdDuration) {
		this.setDuration(cdDuration);
	}

	public Cooldown(long cdDuration, boolean startTime) {
		this(cdDuration);
		this.startTime();
	}

// Cooldown duration

	public void setDuration(long dur){ 	this.cooldownDuration = dur; 						}

	public long getDuration(){ 			return this.cooldownDuration; 						}

// Cooldown time

	public void setTime(long t) { 		this.cooldownTime = t; 								}

	public long getTime(){ 				return this.cooldownTime; 							}

	public void startTime() { 			this.setTime(Time.addToNow(this.getDuration())); 	}

	public boolean isReady() { 			return !Time.isLaterThanNow(this.getTime()); 		}
}
