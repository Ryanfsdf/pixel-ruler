package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class Controller {

    @FXML TextField lengthorig = new TextField();


    double firstposx, firstposy, secondposy, secondposx = 0;
    static double firstnewposx, firstnewposy, secondnewposx, secondnewposy,
            firstdistance, seconddistance = 0;

    public void findLength(ActionEvent actionEvent) {

        if (MouseListener.mousecoordinates != null && !MouseListener.mousecoordinates.isEmpty()) {
            firstposx = Integer.parseInt(MouseListener.
                    mousecoordinates.get(MouseListener.mousecoordinates.size()-2).split(" ")[0]);
            firstposy = Integer.parseInt(MouseListener.
                    mousecoordinates.get(MouseListener.mousecoordinates.size()-2).split(" ")[1]);
        }
        if (MouseListener.mousecoordinates != null && !MouseListener.mousecoordinates.isEmpty()) {
            secondposx = Double.parseDouble(MouseListener.
                    mousecoordinates.get(MouseListener.mousecoordinates.size()-3).split(" ")[0]);
            secondposy = Double.parseDouble(MouseListener.
                    mousecoordinates.get(MouseListener.mousecoordinates.size()-3).split(" ")[1]);
        }

        firstdistance = Math.sqrt(Math.pow((secondposx - firstposx), 2) + Math.pow((secondposy - firstposy), 2));

        displaydistance();
    }
    public void displaydistance() {
        displayMessage.alertBox(Double.toString(Math.round(Double.parseDouble(lengthorig.getText()) *
                100.0 * firstdistance/seconddistance)/100.0), "Distance");
    }

    public static void newCoord() {

        if (MouseListener.originalcoordinates != null && !MouseListener.originalcoordinates.isEmpty()) {
            firstnewposx = Integer.parseInt(MouseListener.originalcoordinates.get(0).split(" ")[0]);
            firstnewposy = Integer.parseInt(MouseListener.originalcoordinates.get(0).split(" ")[1]);
        }
        if (MouseListener.originalcoordinates != null && !MouseListener.originalcoordinates.isEmpty()) {
            secondnewposx = Double.parseDouble(MouseListener.originalcoordinates.get(1).split(" ")[0]);
            secondnewposy = Double.parseDouble(MouseListener.originalcoordinates.get(1).split(" ")[1]);
        }

        seconddistance = Math.sqrt(Math.pow((secondnewposx - firstnewposx), 2) +
                Math.pow((secondnewposy - firstnewposy), 2));
    }
}
