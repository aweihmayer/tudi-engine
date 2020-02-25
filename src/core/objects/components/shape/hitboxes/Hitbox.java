package core.objects.components.shape.hitboxes;

public interface Hitbox {
	public boolean checkCollision(CircleHitbox circ);

	public boolean checkCollision(RectangleHitbox rect);
}
