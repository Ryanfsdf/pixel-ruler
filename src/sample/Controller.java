package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class Controller {

    @FXML TextField lengthorig = new TextField();

    double firstposx = 0;
    double firstposy = 0;
    double firstnewposx = 0;
    double firstnewposy = 0;
    double secondposx = 0;
    double secondposy = 0;
    double secondnewposx = 0;
    double secondnewposy = 0;
    static double firstdistance = 0;
    static double seconddistance = 0;

    public void startRecord(ActionEvent actionEvent) {

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

        firstdistance /= Double.parseDouble(lengthorig.getText());


    }
    public static void displaydistance() {
        displayMessage.alertBox(Double.toString(seconddistance/firstdistance), "Distance");
    }

    public void newCoords(ActionEvent actionEvent) {

        if (MouseListener.newcoordinates != null && !MouseListener.newcoordinates.isEmpty()) {
            firstnewposx = Integer.parseInt(MouseListener.newcoordinates.get(0).split(" ")[0]);
            firstnewposy = Integer.parseInt(MouseListener.newcoordinates.get(0).split(" ")[1]);
        }
        if (MouseListener.newcoordinates != null && !MouseListener.newcoordinates.isEmpty()) {
            secondnewposx = Double.parseDouble(MouseListener.newcoordinates.get(1).split(" ")[0]);
            secondnewposy = Double.parseDouble(MouseListener.newcoordinates.get(1).split(" ")[1]);
        }

        seconddistance = Math.sqrt(Math.pow((secondnewposx - firstnewposx), 2) +
                Math.pow((secondnewposy - firstnewposy), 2));
        displaydistance();
    }
}
