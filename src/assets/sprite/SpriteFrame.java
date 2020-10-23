package assets.sprite;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import gameObjects.components.body.graphics.Sprite;
import math.Angle;
import math.Coord;

public class SpriteFrame {
	private BufferedImage image;
	private int width;
	private int height;

	public SpriteFrame(BufferedImage img, int w, int h) {
		this.image = img;
		this.width = w;
		this.height = h;
	}

// Events

	public void draw(Graphics2D g, Sprite sprite, Coord c, Angle a) {
		AffineTransform gReset = g.getTransform();

		int wr = (int) sprite.getScaledWidth() / 2;
		int hr = (int) sprite.getScaledHeight() / 2;
		int x = (int) c.getX();
		int y = (int) c.getY();

		g.rotate(a.getValueInRadians(), x, y);
		g.drawImage(
			this.image,
			x - wr, y - hr,
			(int) sprite.getWidth(), (int) sprite.getHeight(),
			null);
		g.setTransform(gReset);
	}
}
