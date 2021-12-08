package Controllers.AdminControllers.AdminAuthentification;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminLoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void GoToAdminPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/AdminViews/AdminFunctions/AdminDashBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
