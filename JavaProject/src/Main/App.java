package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import animatefx.animation.FadeInUpBig;
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
        System.out.println(System.getProperty("user.dir") + "/src/Config.properties");
        
                //abdelouhabe rak dima ka t9ob src dir / machi \ alkhra

        FileInputStream config = new FileInputStream(System.getProperty("user.dir") + "/src/Config.properties");
        Prop.load(config);
        Parent root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml"));

        if (Prop.getProperty("MainPage").equals("1")) {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/FirstPage.fxml"));
        } else if (Prop.getProperty("MainPage").equals("2")) {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Employer/HomePage.fxml"));
        } else {
            root = FXMLLoader.load(App.class.getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        }
         
        connection Connect = new connection();
        Connect.ConnectToDataBase();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Hotel BBBE");
        primaryStage.setScene(scene);
        primaryStage.show();

        new FadeInUpBig(root).play();
        primaryStage.setResizable(false);
    }

    // Launch The Main App
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
