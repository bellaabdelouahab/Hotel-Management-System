package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controllers.Admin.Authentification.LoginController;
import Controllers.Employer.Authentification.Login;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstPageConroller implements Initializable{
    DataBaseConnection Connection=new DataBaseConnection();
    @FXML
    private Parent root;
    @FXML
    private Pane ParentPane;
    @FXML
    private Pane ChiledStage;
    // Switch To Admin Page
    public void SwitchToAdminPage(ActionEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        root = loder.load();
        LoginController controller = loder.getController();
        controller.ParentPane=ParentPane;
        controller.connection=Connection;
        FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
        FideOut.play();
        FideOut.setOnFinished(e->{
            ParentPane.getChildren().remove(ChiledStage);
        });
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }

    // Switch To Employer Page
    public void SwitchToEmployerPage(ActionEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        root = loder.load();
        Login controller = loder.getController();
        controller.ParentPane=ParentPane;
        controller.connection=Connection;
        controller.email_text.setText("yassine@gmail.com");
        controller.password_label.setText("yassine2");
        FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
        FideOut.play();
        FideOut.setOnFinished(e->{
            ParentPane.getChildren().remove(ChiledStage);
        });
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }
    public void CloseWindow() {
        Connection.Disconnect();
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.close();
    }
    public void MinimizeWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    /////The only Place To initialize The DataBase connection
    Connection.ConnectToDataBase();
    }
}
