package core.objects.components.actions;

import core.events.UpdateEvent;
import core.objects.Updateable;
import core.objects.components.ComponentList;

public class ActionList implements Updateable {
	protected ComponentList actions = new ComponentList();

	public void update(UpdateEvent ev) { }
}
