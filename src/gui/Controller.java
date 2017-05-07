package gui;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javafx.stage.FileChooser;

import javafx.scene.layout.AnchorPane;
import logic.Game;
import logic.cards.*;

import javax.xml.transform.Source;

/**
 *
 * @author Jan Kubica
 * @login xkubic39
 */
public class Controller implements Initializable {
    Game game = new Game();

    @FXML
    private ImageView SP; // SourcePack
    @FXML
    private ImageView PDP; // SourceDropPack
    @FXML
    private AnchorPane WP; // WorkingPack
    @FXML
    private ImageView TP0; // TargetPack 0
    @FXML
    private ImageView TP1; // TargetPack 1
    @FXML
    private ImageView TP2; // TargetPack 2
    @FXML
    private ImageView TP3; // TargetPack 3

    CardStack source;
    int num;
    boolean first_click = true;

    @FXML
    private void NewGameAction(ActionEvent event) {
        game = new Game();
        redrawGame();
    }

    @FXML
    private void AnotherGameAction(ActionEvent event) {
        //TODO
    }

    @FXML
    private void UndoAction(ActionEvent event) {
        if (game.undo())
            redrawGame();
    }

    @FXML
    private void LoadAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load game ...");
        if (game.load(fileChooser.showOpenDialog(null)))
            redrawGame();
    }

    @FXML
    private void SaveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save game ...");
        game.save(fileChooser.showSaveDialog(null));
    }

    @FXML
    private void handleOnMouseClicked(MouseEvent event) {
        Object o = event.getSource();
        String id;

        if (o instanceof ImageView)
            id = ((ImageView) o).getId();
        else {
            id = o.toString().substring(13, 16);
            System.out.println(id);
            //return;
        }

        if (first_click) {
            source = decodePackID(id);
            num = decodeCardIdx(id);
            first_click = false;
        } else {
            if (source instanceof WorkingPack && num >= 0)
                System.out.println(game.move(source, decodePackID(id), source.size() - num));
            else
                System.out.println(game.move(source, decodePackID(id)));
            first_click = true;

            redrawGame();
        }

    }

    private void redrawGame() {
        for (int i = 0; i < 7; i++)
            printWorkingPack(i);

        printSourcePackPutDownPack();
        printTargetPacks();
    }

    private Integer decodeCardIdx(String id) {
        if (id.length() > 3) {
            return Integer.parseInt(id.substring(4, 6));
        }
        return -1;
    }

    private CardStack decodePackID(String id) {
        if (id.length() >= 3) {
            if (id.startsWith("WP")) {
                return game.board.workingPacks[Character.getNumericValue(id.charAt(2))];
            } else if (id.startsWith("TP")) {
                return game.board.targetPacks[Character.getNumericValue(id.charAt(2))];
            } else if (id.startsWith("PDP")) {
                return game.board.putDownPack;
            }
        }
        return null;
    }

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
        for (Node node : WP.getChildren()) {
            if (node.getId().equals("WP" + number)) {
                if (node instanceof AnchorPane)
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
        redrawGame();

        SP.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (game.nextCard()) {
                    printSourcePackPutDownPack();
                }
                event.consume();
            }
        });
    }

}
