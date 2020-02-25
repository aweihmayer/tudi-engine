package core.objects.main;

import core.objects.components.movement.SimpleMovement;
import core.objects.components.shape.BaseShape;
import math.Coord;

public abstract class SimpleBodyObject extends GameObject {
    public SimpleBodyObject(Coord position, BaseShape graphic, BaseShape hitbox, double speed) {
        graphic.setPosition(position);
        hitbox.setPosition(position);

        this.components.addComponent(graphic);
        this.components.addComponent(hitbox);
        this.components.addComponent(new SimpleMovement(position, speed));
    }

    public SimpleBodyObject(Coord position, BaseShape graphic, BaseShape hitbox) {
        this(position, graphic, hitbox, 0);
    }
}