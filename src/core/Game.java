package core;

import core.handlers.CollisionHandler;
import core.handlers.DrawHandler;
import core.handlers.UpdateHandler;
import core.ui.GameWindow;
import utility.Time;

public class Game {
	private static boolean isPlaying = false;

	private static int framesPerSecond = 60;
	private static double frameDuration;
	private static int timeSkip;

	public static UpdateHandler updateHandler = 		new UpdateHandler();
	public static DrawHandler drawHandler = 			new DrawHandler();
	public static CollisionHandler collisionHandler = 	new CollisionHandler();

	public static void init() {
		frameDuration = 1 / getFPS();
		timeSkip = (int) (frameDuration * 1000);

		GameWindow.init();
		play();
	}
	
	public static void loop() {
		if (isPlaying()) {
			int loops = 0;
			Time nextGameTick = new Time();

			// Update as many times as possible for a given interval
			while (!nextGameTick.isLaterThanNow() && loops < 5){
				updateHandler.handle();
				collisionHandler.handle();

				nextGameTick.add(timeSkip);
				loops++;
			}

			// Draw
			drawHandler.handle();
		}
	}

// State

	public static void start() {
		play();

		while (true) {
			loop();
		}
	}

	public static void play() {
		isPlaying = true;
	}
	
	public static void pause() {
		isPlaying = false;
	}

	public static boolean isPlaying(){
		return isPlaying;
	}
	
// Configurations

	public static void setFPS(int fps) {
		framesPerSecond = fps;
	}

	public static int getFPS() {
		return framesPerSecond;
	}
}
