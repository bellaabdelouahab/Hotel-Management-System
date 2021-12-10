package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // Fonction Of The Main App
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml")); // ("../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hotel BBBE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Launch The Main App
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
