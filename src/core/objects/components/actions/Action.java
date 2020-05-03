package core.objects.components.actions;

import core.objects.Updateable;

public interface Action extends Updateable {
	void perform();

	void whileOnCooldown();

	void whileOffCooldown();
}