package sample;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MouseListener implements NativeMouseInputListener {
    public static LinkedList<String> mousecoordinates = new LinkedList<>();
    public static List<String> originalcoordinates = new ArrayList<>();
    public static boolean newcoord = false;
    public static int whichcoord = 0;

    public void nativeMouseClicked(NativeMouseEvent e) {
        mousecoordinates.add((Integer.toString(e.getX())) + " " + (Integer.toString(e.getY())));
        System.out.print(mousecoordinates);
        if (newcoord == true && whichcoord < 2) {
            originalcoordinates.add((Integer.toString(e.getX())) + " " + (Integer.toString(e.getY())));
            System.out.print(originalcoordinates);
            whichcoord ++;
        }
        if (whichcoord == 2) {
            Controller.newCoord();
            newcoord = false;
            whichcoord = 0;
        }
        if (mousecoordinates.size() > 2) {
            mousecoordinates.removeFirst();
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