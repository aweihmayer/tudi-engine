package gameObjects.components.body.graphics;

import java.awt.Graphics2D;

import assets.sprite.SpriteAnimation;
import assets.sprite.SpriteSheet;
import handlers.registry.AssetRegistry;
import math.Angle;
import math.Coord;
import math.geometry.Rectangle;
import utility.Time;

public class Sprite extends Rectangle implements Graphic {
	protected SpriteSheet spriteSheet;
	protected SpriteAnimation animation;
	protected int animationIndex = 0;
	protected Time nextFrameTime = new Time();
	
	public Sprite(String sheet, double sz) {
		this(sheet, sz, sz);
	}

	public Sprite(String sht, String anim, double sz) {
		this(sht, anim, sz, sz);
	}
	
	public Sprite(String sht, double w, double h) {
		this(sht, SpriteAnimation.DEFAULT, w, h);
	}

	public Sprite(String sht, String anim, double w, double h) {
		super(w, h);
		this.spriteSheet = AssetRegistry.getSpriteSheet(sht);
		this.setAnimation(anim);
	}

// Animation
	
	public void setAnimation(String anim) {
		this.animationIndex = 0;
		this.animation = this.spriteSheet.getAnimation(anim);
		this.startAnimation();
	}
	
// Events

	public void draw(Graphics2D g, Coord c, Angle a) {
		if(this.animation.getFrameCount() > 1 && this.isTimeForNextFrame()) {
			if(this.isAnimationDone() && this.animation.isRepeatable()) {
				this.startAnimation();
			} else {
				this.moveToNextFrame();
			}
		}

		int[] frame = this.animation.getFrameAtIndex(this.animationIndex);
		this.spriteSheet
			.getFrame(frame[0], frame[1])
			.draw(g, this, c, a);
	}
	
	public void startAnimation() {
		this.animationIndex = 0;
		this.nextFrameTime.setTimeToNow(this.animation.getSpeed());
	}
	
	public void moveToNextFrame() {
		this.animationIndex++;
		this.nextFrameTime.setTimeToNow(this.animation.getSpeed());
	}
	
	protected boolean isTimeForNextFrame() {
		return !this.nextFrameTime.isLaterThanNow();
	}
	
	protected boolean isAnimationDone() {
		return this.animationIndex == (this.animation.getFrameCount() - 1);
	}
}
