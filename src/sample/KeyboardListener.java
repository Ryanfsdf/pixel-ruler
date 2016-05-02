package sample;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardListener implements NativeKeyListener {

    public void nativeKeyPressed(NativeKeyEvent e) {
        String keyChecker =  NativeKeyEvent.getKeyText(e.getKeyCode());
        if (keyChecker.equals("F12")) {
            MouseListener.newcoord = true;
            MouseListener.newcoordinates.clear();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}