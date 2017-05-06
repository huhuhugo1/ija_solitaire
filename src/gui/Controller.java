package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.util.HashSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jan Kubica
 * @login xkubic39
 */
public class Controller implements Initializable {

    @FXML
    private ImageView gCardDeck; // fx:id="gCardDeck"
    @FXML
    private ImageView gPutDownPack; // fx:id="gPutDownPack"

    /*
        @FXML
        private void handleButtonAction(ActionEvent event) {
            System.out.println("Toto je cardDeck!");
        }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //   gCardDeck.setImage(new Image("file:/../../lib/res/A(C).png"));

        // click on gCardDeck object
        gCardDeck.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Juuuu, jeeee... CardDeck!");
                //      if (gCardDeck.isVisible())
                //          gCardDeck.setVisible(false);
                event.consume();

                gCardDeck.setImage(new Image("file:/../../lib/res/A(H).png"));
            }
        });

        gPutDownPack.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                gPutDownPack.setImage(new Image("file:/../../lib/res/A(C).png"));

                System.out.println("Juuuu, jeeee... CardDeck!");
                //   if (!gCardDeck.isVisible())
                //      gCardDeck.setVisible(true);

                event.consume();
            }
        });

    }

}