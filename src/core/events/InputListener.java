package core.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import math.Coord;

public class InputListener implements KeyListener, MouseListener {
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

    private static boolean[] mouseButtonsPressed = new boolean[10];

    public static final int LEFT_MOUSE = 1;

// Keyboard

    public void keyPressed(KeyEvent ev) {
        keysPressed[ev.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent ev) {
        keysPressed[ev.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent ev) { }

    public static boolean isKeyPressed(int code) {
        return keysPressed[code];
    }

// Mouse

    public static Coord getMousePosition() {
        Point position = MouseInfo.getPointerInfo().getLocation();
        return new Coord(position.getX(), position.getY());
    }

    public static boolean isMousePressed(int code) {
        return mouseButtonsPressed[code];
    }

    public void mousePressed(MouseEvent ev) {
        mouseButtonsPressed[ev.getButton()] = true;
    }

    public void mouseReleased(MouseEvent ev) {
        mouseButtonsPressed[ev.getButton()] = false;
    }

    public void mouseClicked(MouseEvent ev) { }

    public void mouseEntered(MouseEvent ev) { }

    public void mouseExited(MouseEvent ev) { }
}
