package core.listeners;

import java.awt.event.*;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import math.Coord;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener {
// Keyboard

    private static boolean[] keysPressed = new boolean[150];

    public final static int A_KEY = 65;         public final static int B_KEY = 66;         public final static int C_KEY = 67;
    public final static int D_KEY = 68;         public final static int E_KEY = 69;         public final static int F_KEY = 70;
    public final static int G_KEY = 71;         public final static int H_KEY = 72;         public final static int I_KEY = 73;
    public final static int J_KEY = 74;         public final static int K_KEY = 75;         public final static int L_KEY = 76;
    public final static int M_KEY = 77;         public final static int N_KEY = 78;         public final static int O_KEY = 79;
    public final static int P_KEY = 80;         public final static int Q_KEY = 81;         public final static int R_KEY = 82;
    public final static int S_KEY = 83;         public final static int T_KEY = 84;         public final static int U_KEY = 85;
    public final static int V_KEY = 86;         public final static int W_KEY = 87;         public final static int X_KEY = 88;
    public final static int Y_KEY = 89;         public final static int Z_KEY = 80;

    public final static int ZERO_KEY =  48;     public final static int ONE_KEY =   49;     public final static int TWO_KEY =   50;
    public final static int THREE_KEY = 51;     public final static int FOUR_KEY =  52;     public final static int FIVE_KEY =  53;
    public final static int SIX_KEY =   54;     public final static int SEVEN_KEY = 55;     public final static int EIGHT_KEY = 56;
    public final static int NINE_KEY =  57;

    private static void performAll(HashMap<String, KeyAction> actions, KeyEvent ev) {
        for (Map.Entry<String, KeyAction> entry : actions.entrySet()) {
            entry.getValue().perform(ev);
        }
    }

    public static boolean isKeyPressed(int code) {
        return keysPressed[code];
    }

    // Pressed
    public HashMap<String, KeyAction> keyPressedActions = new HashMap<String, KeyAction>();
    public void keyPressed(KeyEvent ev) {
        keysPressed[ev.getKeyCode()] = true;
        performAll(keyPressedActions, ev);
    }

    // Released
    public HashMap<String, KeyAction> keyReleasedActions = new HashMap<String, KeyAction>();
    public void keyReleased(KeyEvent ev) {
        keysPressed[ev.getKeyCode()] = false;
        performAll(keyReleasedActions, ev);
    }

    // Typed
    public HashMap<String, KeyAction> keyTypedActions = new HashMap<String, KeyAction>();
    public void keyTyped(KeyEvent ev) {
        performAll(keyTypedActions, ev);
    }

// Mouse

    private static Coord mousePosition = new Coord();
    private static boolean[] mouseButtonsPressed = new boolean[10];

    public static final int LEFT_MOUSE = 1;

    private static void performAll(HashMap<String, MouseAction> actions, MouseEvent ev) {
        for (Map.Entry<String, MouseAction> entry : actions.entrySet()) {
            entry.getValue().perform(ev);
        }
    }

    public static Coord getMousePosition() {
        return mousePosition;
    }

    public static boolean isMousePressed(int code) {
        return mouseButtonsPressed[code];
    }

    // Pressed
    public static HashMap<String, MouseAction> mousePressedActions = new HashMap<String, MouseAction>();
    public void mousePressed(MouseEvent ev) {
        mouseButtonsPressed[ev.getButton()] = true;
        performAll(mousePressedActions, ev);
    }

    // Released
    public static HashMap<String, MouseAction> mouseReleasedActions = new HashMap<String, MouseAction>();
    public void mouseReleased(MouseEvent ev) {
        mouseButtonsPressed[ev.getButton()] = false;
        performAll(mouseReleasedActions, ev);
    }

    // Clicked
    public static HashMap<String, MouseAction> mouseClickedActions = new HashMap<String, MouseAction>();
    public void mouseClicked(MouseEvent ev) {
        performAll(mouseClickedActions, ev);
    }

    // Entered
    public static HashMap<String, MouseAction> mouseEnteredActions = new HashMap<String, MouseAction>();
    public void mouseEntered(MouseEvent ev) {
        performAll(mouseEnteredActions, ev);
    }

    // Exited
    public static HashMap<String, MouseAction> mouseExitedActions = new HashMap<String, MouseAction>();
    public void mouseExited(MouseEvent ev) {
        performAll(mouseExitedActions, ev);
    }

    // Dragged
    public static HashMap<String, MouseAction> mouseDraggedActions = new HashMap<String, MouseAction>();
    public void mouseDragged(MouseEvent ev) {
        performAll(mouseDraggedActions, ev);
    }

    // Moved
    public static HashMap<String, MouseAction> mouseMovedActions = new HashMap<String, MouseAction>();
    public void mouseMoved(MouseEvent ev) {
        Point position = MouseInfo.getPointerInfo().getLocation();
        mousePosition.set(
            position.getX(),
            position.getY());
        performAll(mouseMovedActions, ev);
    }
}
