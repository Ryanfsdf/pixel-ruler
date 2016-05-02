package sample;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.util.ArrayList;
import java.util.List;


public class MouseListener implements NativeMouseInputListener {
    public static List<String> mousecoordinates = new ArrayList<>();
    public static List<String> newcoordinates = new ArrayList<>();
    public static boolean newcoord = false;
    public static int whichcoord = 0;

    public void nativeMouseClicked(NativeMouseEvent e) {
        mousecoordinates.add((Integer.toString(e.getX())) + " " + (Integer.toString(e.getY())));
        System.out.print(mousecoordinates);
        if (newcoord == true && whichcoord < 2) {
            newcoordinates.add((Integer.toString(e.getX())) + " " + (Integer.toString(e.getY())));
            System.out.print(newcoordinates);
            whichcoord ++;
        }
        if (whichcoord == 2) {
            newcoord = false;
            whichcoord = 0;
        }

    }

    public void nativeMousePressed(NativeMouseEvent e) {

    }

    public void nativeMouseReleased(NativeMouseEvent e) {

    }

    public void nativeMouseMoved(NativeMouseEvent e) {
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
    }
}