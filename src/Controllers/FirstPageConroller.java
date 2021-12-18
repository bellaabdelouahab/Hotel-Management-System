package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import Controllers.Admin.Authentification.LoginController;
import Controllers.Employer.Authentification.Login;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FirstPageConroller implements Initializable{
    DataBaseConnection Connection=new DataBaseConnection();
    private Parent root;
    @FXML
    private Pane ParentPane;
    @FXML
    private Pane ChiledStage;
    @FXML
    private Pane header;
    private Login controller;

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
    public void SwitchToEmployerPage(ActionEvent event) throws IOException, SQLException {
        Button Btton=(Button)((Node)event.getSource());
        Btton.setDisable(true);
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        root = loder.load();
        Login controller = loder.getController();
        controller.connection=Connection;
        TextFields.bindAutoCompletion(controller.email_text, Connection.GetEmailesHistory());
        FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
        FideOut.play();
        FideOut.setOnFinished(e->{
            ParentPane.getChildren().remove(ChiledStage);
            Btton.setDisable(false);
        });
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }
    public void CloseWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.close();
    }
    public void MinimizeWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.setIconified(true);
    }
    public void headerAnimation(){
        FadeTransition ft = new FadeTransition(Duration.millis(2000),header );
        ft.setFromValue(1.0);
        ft.setToValue(0.95);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    /////The only Place To initialize The DataBase connection
    Connection.ConnectToDataBase();
    headerAnimation();
    }
}
