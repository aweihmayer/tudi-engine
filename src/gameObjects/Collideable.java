package gameObjects;

import handlers.events.CollisionEvent;

public interface Collideable {
	void onCollisionStart(CollisionEvent ev);

	void whileColliding(CollisionEvent ev);

	void onCollisionEnd(CollisionEvent ev);
}