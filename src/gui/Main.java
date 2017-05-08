package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import logic.Game;
import javafx.geometry.Insets;


public class Main extends Application {
    public static int yourIDX;
    public static int games_count = 0;

    public static Stage stage;
    public static Parent[] windows = new Parent[4];

    public static int getFreeIDX() {
        for (int i = 0; i < 4; i++)
            if(windows[i] instanceof Label)
                return i;
        return -1;
    }

    public static int getNonFreeIDX() {
        for (int i = 0; i < 4; i++)
            if(windows[i] instanceof Pane)
                return i;
        return -1;
    }

    public static void redrawStage() {
        GridPane gridPane = new GridPane();
        Scene scene;

        if (Main.games_count > 1) {
            gridPane.setGridLinesVisible(true);
            gridPane.setStyle("-fx-background-color: #000000;");
            gridPane.setHgap(1);
            gridPane.setVgap(1);
    //        gridPane.setPadding(new Insets(1, 1, 1, 1));


            gridPane.add(windows[0], 0, 0);
            gridPane.add(windows[1], 1, 0);
            gridPane.add(windows[2], 0, 1);
            gridPane.add(windows[3], 1, 1);

            scene = new Scene(gridPane, 1280, 960);
        } else {
            int idx = getNonFreeIDX();
            gridPane.add(windows[idx],0,0);
            scene = new Scene(gridPane, 630, 480);
        }

        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitaire 1.0");
        stage.getIcons().add(new Image("/res/icon128x128.png"));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;

        Main.yourIDX = 0;

        windows[0] = FXMLLoader.load(getClass().getResource("gui.fxml"));
        windows[1] = new Label();
        windows[2] = new Label();
        windows[3] = new Label();

        games_count = 1;

        Scene scene = new Scene(windows[0], 630, 480);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitaire 1.0");
        stage.getIcons().add(new Image("/res/icon128x128.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
