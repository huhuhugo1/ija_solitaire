/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hellofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView gCardDeck; // fx:id="gCardDeck"

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Toto je cardDeck!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
/*
        gCardDeck.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("That was easy, wasn't it?");
            }
*/
    }

}