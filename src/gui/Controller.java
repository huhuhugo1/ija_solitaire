package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import logic.Game;
import logic.cards.*;

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
    Game game = new Game();

    private Image printPack(CardStack pack) {
        if (pack.size() > 0)
            if (pack.peak().isTurnedFaceUp())
                return new Image("/res/" + pack.peak() + ".png");
            else
                return new Image("/res/BC.png");
        else
            return null;
    }

    /*
        @FXML
        private void handleButtonAction(ActionEvent event) {
            System.out.println("Toto je cardDeck!");
        }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gCardDeck.setImage(new Image(Main.class.getResourceAsStream("/res/BC.png")));

        // click on gCardDeck object
        gCardDeck.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (game.nextCard()) {
                    gCardDeck.setImage(printPack(game.board.sourcePack));
                    gPutDownPack.setImage(printPack(game.board.putDownPack));
                }
                event.consume();
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