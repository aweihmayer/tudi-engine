package gameObjects.components.actions;

public interface DelayedActionEvents {
	void onStart();

	void whileStarted();

	void whileActive();

	void onPhaseChange();

	void onFinish();

	void onCancel();
}
