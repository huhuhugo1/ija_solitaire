package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.AnchorPane;
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

    @FXML
    private AnchorPane WP;

    private Image printPack(CardStack pack) {
        if (pack.size() > 0)
            if (pack.peak().isTurnedFaceUp())
                return new Image("/res/" + pack.peak() + ".png");
            else
                return new Image("/res/BC.png");
        else
            return null;
    }

    private Image printWorkingPackCard(CardStack pack, int i) {
        if (pack.size() > i)
            if (pack.pack[i].isTurnedFaceUp())
                return new Image("/res/" + pack.pack[i] + ".png");
            else
                return new Image("/res/BC.png");
        else
            return null;
    }

    private void printWorkingPack(int number) {
        AnchorPane pack = null;
        for (Node node: WP.getChildren()) {
            System.out.print(node.getId());
            if (node.getId().equals("WP" + number)) {
                if (node instanceof  AnchorPane)
                    pack = (AnchorPane) node;
                break;
            }
        }

        if (pack != null) {
            System.out.print("\"Hello\"");
            int i = 0;
            for (Node node : pack.getChildren()) {
                if (node instanceof ImageView) {
                    node.setVisible(true);
                    ((ImageView) node).setImage(printWorkingPackCard(game.board.workingPacks[number], i));
                    i++;
                }
            }
        }
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

        //
        for (int i = 0; i < 7; i++)
            printWorkingPack(i);

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