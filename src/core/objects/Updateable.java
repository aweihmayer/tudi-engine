package core.objects;

import core.events.UpdateEvent;

public interface Updateable {
	void update(UpdateEvent ev);
}
