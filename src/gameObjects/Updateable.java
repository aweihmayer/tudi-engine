package gameObjects;

import handlers.events.UpdateEvent;

public interface Updateable {
	void update(UpdateEvent ev);
}
