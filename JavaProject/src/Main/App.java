package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("../resources/view/Form_1_resualt.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hotel BBBE");
            primaryStage.setScene(scene);
            primaryStage.show();
=======
        // Parent root =
        // FXMLLoader.load(getClass().getResource("../Home/FXML/LogIn.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/LogIn.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hotel BBBE");
        primaryStage.setScene(scene);
        primaryStage.show();
>>>>>>> 5dfb3406e22798055a9b951c91280e911bd0ba6c
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
