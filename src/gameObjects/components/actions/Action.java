package gameObjects.components.actions;

import gameObjects.Updateable;

public interface Action extends Updateable {
	void perform();

	void whileOnCooldown();

	void whileOffCooldown();
}