package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Main Class
public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Properties Prop = new Properties();
        FileInputStream config = new FileInputStream(System.getProperty("user.dir") + "/src/Config.properties");
        Prop.load(config);
        Parent root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml"));
        if (Prop.getProperty("MainPage").equals("1")) {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/FirstPage.fxml"));
        } else if (Prop.getProperty("MainPage").equals("2")) {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml"));
        } else {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        }
        
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Hotel BBBE");
        primaryStage.setScene(scene);
        primaryStage.show();
        new FadeIn(root).play();
        primaryStage.setResizable(false);
    }
}
