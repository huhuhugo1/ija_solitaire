package gui;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import logic.Game;
import logic.cards.*;

/**
 * This class controls actions over the objects set in *.xfml file.
 */
public class Controller implements Initializable {
    /**
     * Index where to game is loaded in range 0 to 3.
     */
    private int myIDX = Main.yourIDX;

    /**
     * Game created
     */
    Game game = new Game();

    /**
     * Score label
     */
    @FXML
    private javafx.scene.control.Label score;
    /**
     * SourcePack ImageView
     */
    @FXML
    private ImageView SP; // SourcePack
    /**
     * PutDownPack ImageView
     */
    @FXML
    private ImageView PDP; // SourceDropPack
    /**
     * WorkingPack ImageView
     */
    @FXML
    private AnchorPane WP; // WorkingPack
    /**
     * TargetPack 0 ImageView
     */
    @FXML
    private ImageView TP0; // TargetPack 0
    /**
     * TargetPack 1 ImageView
     */
    @FXML
    private ImageView TP1; // TargetPack 1
    /**
     * TargetPack 2 ImageView
     */
    @FXML
    private ImageView TP2; // TargetPack 2
    /**
     * TargetPack 3 ImageView
     */
    @FXML
    private ImageView TP3; // TargetPack 3

    CardStack source;
    int num;
    boolean first_click = true;

    /**
     * Starts new game
     * @param event
     */
    @FXML
    private void NewGameAction(ActionEvent event) {
        game = new Game();
        redrawGame();
    }

    /**
     * Generates geme on screen
     * @param event
     */
    @FXML
    private void AnotherGameAction(ActionEvent event) {
        if (Main.games_count == 1 && myIDX != 0) {
            Main.windows[0] = Main.windows[myIDX];
            Main.windows[myIDX] = new Label();
            myIDX = 0;
        }

        int idx = Main.getFreeIDX();
        System.out.println(idx);
        if(idx >= 0) {
            try {
                Main.yourIDX = idx;
                Main.windows[idx] = FXMLLoader.load(getClass().getResource("gui.fxml"));
                Main.games_count++;
                Main.redrawStage();
            } catch (Exception e) {
                return;
            }
        }
    }

    /**
     * Close game
     * @param event
     */
    @FXML
    private void CloseGameAction(ActionEvent event) {
        if (Main.games_count == 1)
            System.exit(0);
        Main.windows[myIDX] = new Label();
        Main.games_count--;
        Main.redrawStage();
        return;
    }

    /**
     * Undo one move
     * @param event
     */
    @FXML
    private void UndoAction(ActionEvent event) {
        if (game.undo())
            redrawGame();
    }

    /**
     * Loads game
     * @param event
     */
    @FXML
    private void LoadAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load game ...");
        if (game.load(fileChooser.showOpenDialog(null)))
            redrawGame();
    }

    /**
     * Redraws new game
     * @param event
     */
    @FXML
    private void SaveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save game ...");
        game.save(fileChooser.showSaveDialog(null));
    }

    /**
     * Recognizes where was clicked and make a move
     * @param event
     */
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

    /**
     * Redraws game and tests if win
     */
    private void redrawGame() {
        for (int i = 0; i < 7; i++)
            printWorkingPack(i);

        printSourcePackPutDownPack();
        printTargetPacks();

        score.setText("" + game.getScore());

        if (game.win()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Solitaire");
            alert.setHeaderText(null);
            alert.setContentText("You have won!\nYour score is: " + game.getScore());

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/res/icon128x128.png"));

            alert.showAndWait();

            NewGameAction(null);
        }
    }

    /**
     * Decodes Card index
     * @param id id of Card
     */
    private Integer decodeCardIdx(String id) {
        if (id.length() > 3) {
            return Integer.parseInt(id.substring(4, 6));
        }
        return -1;
    }

    /**
     * Decodes Pack index
     * @param id id of Pack
     */
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

    /**
     * Sets image for Card in Pack
     * @param pack concrete Pack
     * @param i number of Card from top
     */
    private Image printCardFromPack(CardStack pack, int i) {
        if (pack.size() > i && i >= 0)
            if (pack.pack[i].isTurnedFaceUp())
                return new Image("/res/" + pack.pack[i] + ".png");
            else
                return new Image("/res/BC.png");
        else
            return null;
    }

    /**
     * Sets an image on top
     * @param pack ConcretePack
     * @return Image
     */
    private Image printCardOnTop(CardStack pack) {
        return printCardFromPack(pack, pack.size() - 1);
    }

    /**
     * Prints WorkingPack
     * @param number number id of WP
     */
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

    /**
     * Prints TargetPack
     */
    private void printTargetPacks() {
        TP0.setImage(printCardOnTop(game.board.targetPacks[0]));
        TP1.setImage(printCardOnTop(game.board.targetPacks[1]));
        TP2.setImage(printCardOnTop(game.board.targetPacks[2]));
        TP3.setImage(printCardOnTop(game.board.targetPacks[3]));
    }
    /**
     * Prints SourcePack and PutDownPack
     */
    private void printSourcePackPutDownPack() {
        SP.setImage(printCardOnTop(game.board.sourcePack));
        PDP.setImage(printCardOnTop(game.board.putDownPack));
    }

    /**
     * Initialize scene and listen on SourcePack
     * @param  url url
     * @param  rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        redrawGame();

        SP.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (game.nextCard()) {
                    redrawGame();
                }
                event.consume();
            }
        });
    }

}
