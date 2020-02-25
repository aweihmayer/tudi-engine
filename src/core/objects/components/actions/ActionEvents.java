package core.objects.components.actions;

public interface ActionEvents {
	void perform();

	void whileOnCooldown();

	void whileOffCooldown();
}