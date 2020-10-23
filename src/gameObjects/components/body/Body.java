package gameObjects.components.body;

import handlers.events.UpdateEvent;
import gameObjects.Drawable;
import gameObjects.Updateable;
import gameObjects.components.BaseComponent;
import gameObjects.components.body.graphics.Graphic;
import gameObjects.components.body.hitboxes.CircleHitbox;
import gameObjects.components.body.hitboxes.Hitbox;
import gameObjects.components.body.hitboxes.RectangleHitbox;
import math.Angle;
import math.Coord;
import math.physics.Force;
import math.physics.Forces;

import java.awt.*;

public class Body extends BaseComponent implements Updateable, Drawable {
	protected Coord position;
	protected Angle rotation;

	protected Graphic graphic;
	protected Hitbox hitbox;

	protected Forces forces = new Forces();

	public Body(Coord c, Graphic g, Hitbox h) {
		this(c, new Angle(), g, h);
	}

	public Body(Coord c, Angle a, Graphic g, Hitbox h) {
		this.setPosition(c);
		this.setRotation(a);
		this.setGraphic(g);
		this.setHitbox(h);
	}

	public void update(UpdateEvent ev) {
		Force force = this.getForces().getResultingForce();
		Coord movement = force.getHead();

		movement.setX(
			movement.getX() * ev.getFractionOfSecond());
		movement.setY(
			movement.getY() * ev.getFractionOfSecond());

		this.getPosition().add(movement);
		this.getForces().removeExpiredForces();
	}

	public void draw(Graphics2D g) {
		Graphic graphic = this.getGraphic();

		if(graphic != null) {
			graphic.draw(g, this.getPosition(), this.getRotation());
		}
	}

// Position

	public void setPosition(Coord pos) {
		this.position = pos;
	}

	public Coord getPosition() {
		return this.position;
	}

// Rotation

	public void setRotation(Angle rot) {
		this.rotation = rot;
	}

	public Angle getRotation() {
		return this.rotation;
	}

// Graphic

	public void setGraphic(Graphic graphic) {
		this.graphic = graphic;
	}

	public Graphic getGraphic() {
		return this.graphic;
	}

// Hitbox

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public Hitbox getHitbox() {
		return this.hitbox;
	}

// Collision

	public boolean isCollisionEnabled() {
		return this.getHitbox() != null;
	}

	public boolean checkCollision(Body foreignBody) {
		Hitbox hitbox = this.getHitbox();
		Hitbox foreignHitbox = foreignBody.getHitbox();
		String className = hitbox.getClass().getName();

		boolean isCollisionDetected = false;

		switch (className) {
			case "CircleHitbox":
				 isCollisionDetected = hitbox.checkCollision(
					this.getPosition(),
					this.getRotation(),
					(CircleHitbox) foreignHitbox,
					foreignBody.getPosition(),
					foreignBody.getRotation());
				break;
			case "RectangleHitbox":
				isCollisionDetected = hitbox.checkCollision(
					this.getPosition(),
					this.getRotation(),
					(RectangleHitbox) foreignHitbox,
					foreignBody.getPosition(),
					foreignBody.getRotation());
				break;
		}

		return isCollisionDetected;
	}

// Physics

	public Forces getForces() {
		return this.forces;
	}
}
