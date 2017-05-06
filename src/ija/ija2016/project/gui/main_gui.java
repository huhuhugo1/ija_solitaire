package ija.ija2016.project.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class main_gui extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitaire 1.0");
        stage.getIcons().add(new Image("/res/icon128x128.png"));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
