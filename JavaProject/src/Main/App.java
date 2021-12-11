package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // Fonction Of The Main App
    @Override
    public void start(Stage primaryStage) throws IOException {
        Properties Prop = new Properties();
        System.out.println(System.getProperty("user.dir")+"\\src\\Config.properties");
        FileInputStream config = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
        Prop.load(config);
        Parent root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/FirstPage.fxml"));

        if(Prop.getProperty("MainPage").equals("1")){
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/FirstPage.fxml"));
        }
        else if(Prop.getProperty("MainPage").equals("2")){
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml"));
        }
        else{
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        }
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
