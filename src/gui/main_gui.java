package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 *
 * @author David
 */
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
/*
    public class ImageClickExample extends Application {

        @Override
        public void start(Stage primaryStage) {
            ImageView img = new ImageView("http://i.stack.imgur.com/oURrw.png");
            img.setPickOnBounds(true); // allows click on transparent areas
            img.setOnMouseClicked((MouseEvent e) -> {
                System.out.println("Clicked!"); // change functionality
            });
            Scene scene = new Scene(new StackPane(img));
            primaryStage.setTitle("Image Click Example");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        }
*/

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
    
}
