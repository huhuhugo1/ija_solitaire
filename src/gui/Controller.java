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
    Game game = new Game();

    @FXML
    private ImageView SP; // fx:id="SP"
    @FXML
    private ImageView PDP; // fx:id="PDP"
    @FXML
    private AnchorPane WP;
    @FXML
    private ImageView TP0;
    @FXML
    private ImageView TP1;
    @FXML
    private ImageView TP2;
    @FXML
    private ImageView TP3;

    private Image printCardFromPack(CardStack pack, int i) {
        if (pack.size() > i && i >= 0)
            if (pack.pack[i].isTurnedFaceUp())
                return new Image("/res/" + pack.pack[i] + ".png");
            else
                return new Image("/res/BC.png");
        else
            return null;
    }

    private Image printCardOnTop(CardStack pack) {
        return printCardFromPack(pack, pack.size() - 1);
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
            int i = 0;
            for (Node node : pack.getChildren()) {
                if (node instanceof ImageView) {
                    Image image = printCardFromPack(game.board.workingPacks[number], i);
                    if (image == null)
                        node.setVisible(false);
                    else
                        node.setVisible(true);

                    ((ImageView) node).setImage(image);
                    i++;
                }
            }
        }
    }

    private void printTargetPacks() {
        TP0.setImage(printCardOnTop(game.board.targetPacks[0]));
        TP1.setImage(printCardOnTop(game.board.targetPacks[1]));
        TP2.setImage(printCardOnTop(game.board.targetPacks[2]));
        TP3.setImage(printCardOnTop(game.board.targetPacks[3]));
    }

    private void printSourcePackPutDownPack() {
        SP.setImage(printCardOnTop(game.board.sourcePack));
        PDP.setImage(printCardOnTop(game.board.putDownPack));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 7; i++)
            printWorkingPack(i);

        printSourcePackPutDownPack();

        SP.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (game.nextCard()) {
                    printSourcePackPutDownPack();
                }
                event.consume();
            }
        });

        PDP.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                PDP.setImage(new Image("file:/../../lib/res/A(C).png"));

                System.out.println("Juuuu, jeeee... CardDeck!");
                //   if (!SP.isVisible())
                //      SP.setVisible(true);

                event.consume();
            }
        });

    }

}
