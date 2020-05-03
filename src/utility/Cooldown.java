package utility;

public class Cooldown extends Time {
	protected long cooldownDuration = 0;

	public Cooldown() { }

	public Cooldown(long cdDuration) {
		this.setDuration(cdDuration);
	}

	public Cooldown clone() {
		return new Cooldown(this.getDuration());
	}

// Cooldown duration

	public void setDuration(long dur){
		this.cooldownDuration = dur;
	}

	public long getDuration(){
		return this.cooldownDuration;
	}

// Cooldown time

	public void startTime() {
		this.setTimeToNow(this.getDuration());
	}

	public boolean isReady() {
		return !this.isLaterThanNow();
	}
}
