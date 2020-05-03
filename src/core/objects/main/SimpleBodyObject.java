package core.objects.main;

import core.objects.components.body.Body;
import core.objects.components.body.graphics.Graphic;
import core.objects.components.body.hitboxes.Hitbox;
import math.Coord;

public abstract class SimpleBodyObject extends GameObject {
	public SimpleBodyObject(Coord position, Graphic graphic, Hitbox hitbox) {
		Body body = new Body(position, graphic, hitbox);
		this.components.addComponent(body);
	}

	public SimpleBodyObject(Coord position, Body body) {
		body.setPosition(position);
		this.components.addComponent(body);
	}

	public SimpleBodyObject(Body body) {
		this.components.addComponent(body);
	}
}