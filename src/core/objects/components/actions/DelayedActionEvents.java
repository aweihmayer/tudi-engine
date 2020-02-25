package core.objects.components.actions;

public interface DelayedActionEvents {
	void onStart();

	void whileStarted();

	void whileActive();

	void whileInactive();

	void onPhaseChange();

	void onFinish();

	void onCancel();
}
