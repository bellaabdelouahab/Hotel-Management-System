package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import Controllers.FirstPageConroller;
import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
    public void start(Stage primaryStage) throws IOException, SQLException {
        Properties Prop = new Properties();
        FileInputStream config = new FileInputStream(System.getProperty("user.dir") + "/src/Config.properties");
        Prop.load(config);
        FXMLLoader loader = new FXMLLoader(App.class.getResource("../Resources/VIEW/FirstPage.fxml"));
        Parent root=loader.load();
        if (Prop.getProperty("MainPage").equals("null")) {
        } else if (Prop.getProperty("MainPage").equals("0")) {
            FirstPageConroller controller = loader.getController();
            controller.SwitchToEmployerPage(new ActionEvent());
        } else if (Prop.getProperty("MainPage").equals("1")){
            FirstPageConroller controller = loader.getController();
            controller.SwitchToAdminPage(new ActionEvent());
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
