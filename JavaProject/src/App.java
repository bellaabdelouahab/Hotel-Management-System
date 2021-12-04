import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Home/Cliend_side_Form_1.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hotel BBBE");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
