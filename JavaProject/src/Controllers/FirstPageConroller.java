package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FirstPageConroller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Switch To Admin Page
    @FXML
    public void SwitchToAdminPage(ActionEvent event) throws IOException {
        root = FXMLLoader
                .load(getClass().getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Switch To Employer Page
    @FXML
    public void SwitchToEmployerPage(ActionEvent event) throws IOException {
        root = FXMLLoader
                .load(getClass().getResource("../Resources/VIEW/Employer/Authentification/EmployerLogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
