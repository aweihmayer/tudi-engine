package core.handlers;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import core.registry.GameRegistryList;
import core.registry.ObjectRegistry;
import core.objects.BaseObject;
import core.objects.Drawable;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;
import core.objects.main.GameObject;
import core.ui.GameWindow;

public class DrawHandler implements Handler {
	private GameRegistryList<Integer>[] layers = (GameRegistryList<Integer>[]) new Object[] {
		(GameRegistryList<Integer>) new Object(),
		(GameRegistryList<Integer>) new Object(),
		(GameRegistryList<Integer>) new Object(),
		(GameRegistryList<Integer>) new Object() };

	public void add(GameObject obj) {
		int layer = obj.getDrawHandlerLayer();
		int registryIndex = obj.getRegistryIndex();

		int handlerIndex = this.layers[layer].add(registryIndex);
		obj.setDrawHandlerIndex(handlerIndex);
	}

	public void clear() {
		for (int l = 0; l < layers.length; l++) {
			this.layers[l].clear();
		}
	}

	public void remove(GameObject obj) {
		int layer = obj.getDrawHandlerLayer();
		this.layers[layer].remove(obj.getDrawHandlerIndex());
	}

	public void handle() {
		BufferStrategy bufferStrategy = GameWindow.getCanvas().getBufferStrategy();
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		GameWindow.clearCanvas(g);

		for (int l = 0; l < layers.length; l++) {
			GameObject[] objects = ObjectRegistry.getWithReferenceList(this.layers[l]);

			for (int i = 0; i < objects.length; i++) {
				this.draw(objects[i], g);
				this.handleComponents(objects[i].components, g);
			}
		}

		bufferStrategy.show();
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
		if (obj instanceof Drawable) {
			AffineTransform gRestorePoint = g.getTransform();
			((Drawable) obj).draw(g);
			g.setTransform(gRestorePoint);
		}
	}
}