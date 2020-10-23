package handlers.events;

import gameObjects.components.body.Body;

public class CollisionEvent {
    private Body body;

    public CollisionEvent(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return this.body;
    }
}
