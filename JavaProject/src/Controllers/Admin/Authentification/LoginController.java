package Controllers.Admin.Authentification;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import Main.connection;
=======
import Main.DataBaseConnection;
import animatefx.animation.FadeInUpBig;
>>>>>>> e953a416f2d388a0e17aa75f2031f1cf415489aa
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

    connection connection = new connection();

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

        String Email = Email_Area.getText();
        String Password = Password_Area.getText();

        ResultSet ResultSet = connection.LoginWithDataBase(Email , Password);

        if (ResultSet.next() == true){
            root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/DashBoard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            new FadeInUpBig(root).play();

            
        } else {
            Error_Message.setText("Invalid Information Please Try Again");
        }
    }
}
