package gameObjects.components.actions;

import gameObjects.components.BaseComponent;
import handlers.events.UpdateEvent;
import utility.Cooldown;

public abstract class BaseAction extends BaseComponent implements Action {
	protected Cooldown cooldown = new Cooldown();

	public BaseAction() { }

	public BaseAction(long cdDuration) {
		this.cooldown.setDuration(cdDuration);
	}
	
// Events

	public void update(UpdateEvent ev) {
		if(this.isOnCooldown()) {
			this.whileOnCooldown();
		} else {
			this.whileOffCooldown();
		}
	}

// Cooldown

	public void startCooldown() {
		this.cooldown.startTime();
	}

	public boolean isOnCooldown() {
		return !this.cooldown.isReady();
	}
}
