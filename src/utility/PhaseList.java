package utility;

import core.objects.Updateable;
import core.events.UpdateEvent;

// TODO - Implement pause
public class PhaseList implements Updateable {
	protected int currentPhase = -1;
	protected long[] phaseDurations;
	protected Cooldown cooldown = new Cooldown();

	public PhaseList() { }

	public PhaseList(long[] phaseDurations) {
		this.setPhaseDurations(phaseDurations);
	}

	public void update(UpdateEvent ev) {
		if(this.isCurrentPhaseDone()) {
			if(this.isOnLastPhase()) {
				this.reset();
			} else {
				this.goToNextPhase();
			}
		}
	}

	public PhaseList clone() {
		return new PhaseList(this.phaseDurations.clone());
	}

// Actions

	public void start() {
		this.setCurrentPhase(0);
		this.startTime();
	}

	public void cancel() {
		this.reset();
	}

// Phases

	public boolean isCurrentPhaseDone() {
		return (this.isActive() && this.cooldown.isReady());
	}

	private void goToNextPhase() {
		this.currentPhase++;
		this.startTime();
	}

	private void reset() {
		this.setCurrentPhase(-1);
	}

	public void setPhaseDurations(long[] durations) {
		this.phaseDurations = durations;
	}

	public long getPhaseDuration(int i) {
		return this.phaseDurations[i];
	}

	public int countPhases() {
		return this.phaseDurations.length - 1;
	}

// Current phase

	public void setCurrentPhase(int i) {
		this.currentPhase = i;
	}

	public int getCurrentPhase() {
		return this.currentPhase;
	}

	public boolean isOnLastPhase() {
		return this.getCurrentPhase() == this.countPhases();
	}

// State

	public boolean isStarted() {
		return this.getCurrentPhase() != -1;
	}

	public boolean isActive() {
		return this.isStarted(); // TODO - Change when implementing pause
	}

// Time

	private void startTime() {
		int phase = this.getCurrentPhase();
		long dur = this.getPhaseDuration(phase);
		this.cooldown.setDuration(dur);
		this.cooldown.startTime();
	}
}
