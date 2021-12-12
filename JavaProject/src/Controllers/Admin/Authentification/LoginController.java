package Controllers.Admin.Authentification;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController {

    DataBaseConnection connection = new DataBaseConnection();

    @FXML
    private TextField Email_Area;

    @FXML
    private Label Error_Message;

    @FXML
    private PasswordField Password_Area;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void GoToAdminPage(ActionEvent event) throws IOException, SQLException {

        String Nam = Email_Area.getText();
        ResultSet ResultSet = connection.LoginWithDataBase(Nam);

        if (ResultSet.next() == true){
            root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/DashBoard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Error_Message.setText("Invalid Information Please Try Again");
        }
    }
}
