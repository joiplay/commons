package cyou.joiplay.commons.model;

import android.view.KeyEvent;

public class GamePad {
    public Boolean diagonalMovement = false;
    public Boolean hideGamepad = false;
    public Integer btnOpacity = 100;
    public Integer btnScale = 100;
    public Integer[] aKeyCode = new Integer[]{KeyEvent.KEYCODE_X, KeyEvent.KEYCODE_W};
    public Integer[] bKeyCode = new Integer[]{KeyEvent.KEYCODE_SHIFT_LEFT, KeyEvent.KEYCODE_A};
    public Integer[] cKeyCode = new Integer[]{KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_S};
    public Integer[] xKeyCode = new Integer[]{KeyEvent.KEYCODE_Z, KeyEvent.KEYCODE_D};
    public Integer[] yKeyCode = new Integer[]{KeyEvent.KEYCODE_CTRL_LEFT, KeyEvent.KEYCODE_C};
    public Integer[] zKeyCode = new Integer[]{KeyEvent.KEYCODE_Q, KeyEvent.KEYCODE_V};
    public Integer[] lKeyCode = new Integer[]{KeyEvent.KEYCODE_ENTER,KeyEvent.KEYCODE_ENTER};
    public Integer[] rKeyCode = new Integer[]{KeyEvent.KEYCODE_ESCAPE, KeyEvent.KEYCODE_ESCAPE};
    public Integer[] clKeyCode = new Integer[]{KeyEvent.KEYCODE_F2, KeyEvent.KEYCODE_F2};
    public Integer[] crKeyCode = new Integer[]{KeyEvent.KEYCODE_F8, KeyEvent.KEYCODE_F8};
}
