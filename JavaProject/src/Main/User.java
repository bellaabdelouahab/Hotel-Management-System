package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class User extends Application {
    @Override
    public void start(Stage primary) throws Exception {
        // Parent root =
        // FXMLLoader.load(getClass().getResource("../Home/FXML/LogIn.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/AdminPage/AdminLogin.fxml"));
        Scene scene = new Scene(root);
        primary.setTitle("Hotel BBBE");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
