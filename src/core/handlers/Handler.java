package core.handlers;

import core.objects.main.GameObject;

public interface Handler {
	public void add(GameObject obj);

	public void remove(GameObject obj);

	public void clear();

	public void handle();
}
