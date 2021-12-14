package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeInUpBig;
import animatefx.animation.FadeOutLeftBig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FirstPageConroller implements Initializable{
    @FXML
    private Parent root;
    @FXML
    private Pane FIRSTPAGE;

    @FXML
    private FlowPane ParentPane;

    // Switch To Admin Page
    public void SwitchToAdminPage(ActionEvent event) throws IOException {
        ParentPane.getChildren().remove(FIRSTPAGE);
        root = FXMLLoader.load(getClass().getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        ParentPane.getChildren().add(root);
    }

    // Switch To Employer Page
    public void SwitchToEmployerPage(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
        new FadeOutLeftBig(FIRSTPAGE);
        ParentPane.getChildren().remove(FIRSTPAGE);

    }
    public void CloseWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.close();
    }
    public void MinimizeWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.setIconified(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
}
