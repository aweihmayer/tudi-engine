package gameObjects.components.actions;

import handlers.events.UpdateEvent;
import gameObjects.Updateable;
import gameObjects.components.ComponentList;

public class ActionList extends ComponentList<BaseAction> implements Updateable {
	protected ComponentList actions = new ComponentList();

	public void update(UpdateEvent ev) { }
}
