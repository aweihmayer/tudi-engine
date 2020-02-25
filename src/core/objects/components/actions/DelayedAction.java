package core.objects.components.actions;

import core.events.UpdateEvent;
import utility.PhaseList;

public abstract class DelayedAction extends BaseAction implements DelayedActionEvents {
	protected PhaseList phases = new PhaseList();

	public DelayedAction(long[] phaseDurations, long cdDuration) {
		super(cdDuration);
		this.phases.setPhaseDurations(phaseDurations);
	}

// Events

	public void update(UpdateEvent ev) {
		super.update(ev);

		if(this.isActive()) {
			this.updateActive();
		} else {
			this.whileInactive();
		}

		this.phases.update(ev);
	}

	protected void updateActive() {
		if(this.phases.isCurrentPhaseDone()) {
			if(this.phases.isOnLastPhase()) {
				this.onFinish();
			} else {
				this.whileActive();
			}
		} else {
			this.whileActive();
		}
	}

// Actions

	public void start() {
		this.onStart();
		this.phases.start();
	}

	public void cancel() {
		this.onCancel();
		this.phases.cancel();
	}

// State

	public boolean isStarted() {
		return this.phases.isStarted();
	}

	public boolean isActive() {
		return this.phases.isActive();
	}
}
