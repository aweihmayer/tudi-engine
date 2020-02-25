package core.events;

import core.objects.components.shape.hitboxes.Hitbox;

public class CollisionEvent {
    private Hitbox object;

    public CollisionEvent(Hitbox obj) {
        this.object = obj;
    }

    public Hitbox getObject() {
        return this.object;
    }
}
