package core.objects.components.actions;

import core.objects.components.BaseComponent;
import core.objects.Updateable;
import core.events.UpdateEvent;
import utility.Cooldown;

public abstract class BaseAction extends BaseComponent implements ActionEvents, Updateable {
	protected Cooldown cooldown = new Cooldown();

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
