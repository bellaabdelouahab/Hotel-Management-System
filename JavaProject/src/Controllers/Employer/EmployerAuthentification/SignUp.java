package Controllers.Employer.EmployerAuthentification;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class SignUp {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Switch To Sign In page of Employer
    @FXML
    public void SwitchToSignIn(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/EmployerViews/EmployerAuthentification/EmployerLogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
