package core.objects.components.shape.graphics.sprite;

import java.awt.Graphics2D;

import core.registry.AssetRegistry;
import core.events.UpdateEvent;
import core.objects.Drawable;
import core.objects.Updateable;
import core.objects.components.shape.Rectangle;
import utility.Time;

public class Sprite extends Rectangle implements Drawable, Updateable {
	protected SpriteSheet spriteSheet;
	protected SpriteAnimation animation;
	protected int animationIndex = 0;
	protected long nextFrameTime = 0;
	
	public Sprite(String sht, double sz) {
		this(sht, sz, sz);
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
	
	public void update(UpdateEvent ev) {
		if(this.animation.getFrameCount() > 1 && this.isTimeForNextFrame()) {
			if(this.isAnimationDone() && this.animation.isRepeatable()) {
				this.startAnimation();
			} else {
				this.moveToNextFrame();
			}
		}
	}

	public void draw(Graphics2D g) {		
		int[] frame = this.animation.getFrameAtIndex(this.animationIndex);
		this.spriteSheet.getFrame(frame[0], frame[1]).draw(g, this);
	}
	
	public void startAnimation() {
		this.animationIndex = 0;
		this.nextFrameTime = Time.addToNow(this.animation.getSpeed());
	}
	
	public void moveToNextFrame() {
		this.animationIndex++;
		this.nextFrameTime = Time.addToNow(this.animation.getSpeed());
	}
	
	protected boolean isTimeForNextFrame() {
		return !Time.isLaterThanNow(this.nextFrameTime);
	}
	
	protected boolean isAnimationDone() {
		return this.animationIndex == (this.animation.getFrameCount() - 1);
	}
}
