package core.handlers;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import core.objects.BaseObject;
import core.objects.Drawable;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;
import core.objects.components.body.Body;
import core.objects.components.body.graphics.Graphic;
import core.objects.main.GameObject;
import core.ui.GameWindow;

public class DrawHandler extends BaseHandler {
	public void handle() {
		this.clean();
		GameObject[] objects = this.ref.toArray();
		GameObject obj;

		BufferStrategy bufferStrategy = GameWindow.getCanvas().getBufferStrategy();
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		GameWindow.clearCanvas(g);

		for (int i = 0; i < objects.length; i++) {
			obj = objects[i];

			if (obj.body != null) {
				obj.body.draw(g);
			}

			this.handleComponents(obj.components, g);
		}

		bufferStrategy.show();
	}

	public void add(GameObject obj) {
		if (obj instanceof Drawable) {
			super.add(obj);
		}
	}

	private void handleComponents(BaseComponent obj, Graphics2D g) {
		if (obj instanceof ComponentList) {
			for (BaseComponent comp : ((ComponentList<BaseComponent>) obj).getComponents()) {
				this.handleComponents(comp, g);
			}
		}

		this.draw(obj, g);
	}

	private void draw(BaseObject obj, Graphics2D g) {
		if (obj instanceof Body) {
			AffineTransform gRestorePoint = g.getTransform();
			((Body) obj).draw(g);
			g.setTransform(gRestorePoint);
		}
	}
}