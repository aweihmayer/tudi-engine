package core.objects.components.shape.graphics.sprite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteSheet {	
	protected String name;
	protected String source;
	protected BufferedImage image;
	protected SpriteFrame[][] frames;
	protected int width;
	protected int height;
	protected HashMap<String, SpriteAnimation> animations = new HashMap<String, SpriteAnimation>();

	public SpriteSheet(String name, String src, int frmW, int frmH) {
		this.name = name;

		try {
			//InputStream stream = getClass().getResourceAsStream(source);
			File file = new File("./" + src);
			this.image = ImageIO.read(file);
			this.width = this.image.getWidth();
			this.height = this.image.getHeight();
			this.splitSheetIntoFrames(frmW, frmH);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		this.addAnimation(new SpriteAnimation(SpriteAnimation.DEFAULT));
	}

	private void splitSheetIntoFrames(int frmW, int frmH) {
		int colCount = this.width / frmW;
		int rowCount = this.height / frmH;
		this.frames = new SpriteFrame[colCount][rowCount];

		for(int col = 0; col < colCount; col++) {
			for(int row = 0; row < rowCount; row++) {
				BufferedImage frmImg = this.image.getSubimage(
					col * frmW, row * frmH,
					frmW, frmH);
				this.frames[col][row] = new SpriteFrame(frmImg, frmW, frmH);
			}
		}
	}

// Animation
	
	public void addAnimation(SpriteAnimation anim) { 		this.animations.put(anim.getName(),  anim); 	}
	
// Configurations
	
	public String getName() { 								return this.name; 								}
	
	public SpriteFrame getFrame(int col, int row) { 		return this.frames[col][row]; 					}
	
	public String getSource() { 							return this.source; 							}
			
	public SpriteAnimation getAnimation(String name) { 		return this.animations.get(name); 				}
}
