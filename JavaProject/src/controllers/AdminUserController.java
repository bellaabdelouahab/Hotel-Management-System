package controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminUserController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToUsers(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/view/Admin Page/AdminUser.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
