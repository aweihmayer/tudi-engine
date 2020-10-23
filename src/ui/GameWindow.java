package ui;

import listeners.InputListener;
import math.Coord;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class GameWindow {
	private static JFrame frame;
	private static Canvas canvas;

	public static void init() {				
		createFrame();
		createCanvas();
		
		frame.add(canvas);
		canvas.createBufferStrategy(2);
	}
	
	private static void createFrame() {
		frame = new JFrame();
		frame.addMouseListener(new InputListener());
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setVisible(true);
	}
	
	private static void createCanvas() {
		canvas = new Canvas();
		canvas.addKeyListener(new InputListener());
		canvas.addMouseListener(new InputListener());
		canvas.setIgnoreRepaint(true);
		canvas.setBackground(Color.WHITE);
		canvas.setVisible(true);
		canvas.setFocusable(true);
	}
	
	public static void clearCanvas(Graphics g) {
		canvas.paint(g);
	}
	
// Canvas
	
	public static Graphics2D getDrawGraphics() {
		return (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();
	}
	
	public static int getWidth() {
		return canvas.getWidth();
	}
	
	public static int getHeight() {
		return canvas.getHeight();
	}
	
	public static Canvas getCanvas() {
		return canvas;
	}

// Screen

	public static boolean isOnScreen(Coord c) {
		double x = c.getX();
		double y = c.getY();

		return (
			x > 0
			&& x < getWidth()
			&& y > 0
			&& y < getHeight());
	}
}
