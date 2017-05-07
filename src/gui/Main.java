package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import logic.Game;

public class Main extends Application {

    protected int games_count = 0;

    @FXML
    private void AnotherGameAction(ActionEvent event) {
        //TODO
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent window_0 = FXMLLoader.load(getClass().getResource("gui.fxml"));
        Parent window_1 = FXMLLoader.load(getClass().getResource("gui.fxml"));
        Parent window_2 = FXMLLoader.load(getClass().getResource("gui.fxml"));
        Parent window_3 = FXMLLoader.load(getClass().getResource("gui.fxml"));

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setStyle("-fx-background-color: #000000;");
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(window_0, 0, 0);
        gridPane.add(window_1, 1, 0);
        gridPane.add(window_2, 0, 1);
        gridPane.add(window_3, 1, 1);

        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitaire 1.0");
        stage.getIcons().add(new Image("/res/icon128x128.png"));

        Scene scene = new Scene(gridPane, 1275, 955);
        stage.setScene(scene);
        stage.show();

        /*
        Scene scene = new Scene(window_0, 630, 480);
        stage.setScene(scene);
        stage.show();
        */
        games_count++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
