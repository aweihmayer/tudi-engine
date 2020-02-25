package core.objects.components.shape.graphics.sprite;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import math.Angle;
import math.Coord;

public class SpriteFrame {
	protected BufferedImage image;
	protected int width;
	protected int height;

	public SpriteFrame(BufferedImage img, int w, int h) {
		this.image = img;
		this.width = w;
		this.height = h;
	}

// Events
	
	public void draw(Graphics2D g, Sprite sprite) {
		AffineTransform gReset = g.getTransform();
		
		Coord pos = sprite.getPosition();
		Angle rot = sprite.getRotation();
		
		int wr = (int) sprite.getWidth() / 2;
		int hr = (int) sprite.getHeight() / 2;
		int x = (int) pos.getX();
		int y = (int) pos.getY();

		g.rotate(rot.getValueInRadians(), x, y);
		g.drawImage(
			this.image,
			x - wr, y - hr,
			(int) sprite.getWidth(), (int) sprite.getHeight(),
			null);
		g.setTransform(gReset);
	}
}
