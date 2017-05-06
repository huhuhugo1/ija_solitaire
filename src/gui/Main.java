package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
*/
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

        Scene scene = new Scene(root, 630, 480);
        stage.setScene(scene);

        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitaire 1.0");
        stage.getIcons().add(new Image("file:/../../lib/res/icon128x128.png"));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
