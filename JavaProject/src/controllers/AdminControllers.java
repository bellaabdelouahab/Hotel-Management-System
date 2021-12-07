package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminControllers {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/view/LogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
