package Controllers.Admin.Authentification;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controllers.Admin.Functions.LeaderBord;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable{

    public DataBaseConnection connection ;

    @FXML
    private TextField Email_Area;

    @FXML
    private Label Error_Message;

    @FXML
    private PasswordField Password_Area;
    private Parent root;
    @FXML
    public Pane ParentPane;
    @FXML
    private BorderPane ChiledStage;

    public ArrayList<String> request;
    @FXML
    public void GoToAdminPage(ActionEvent event) throws IOException, SQLException {

        String Email = Email_Area.getText();
        String Password = Password_Area.getText();

        ResultSet ResultSet = connection.LoginWithDataBase(Email , Password);

        if (ResultSet.next() == true){
            FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/LeaderBoard.fxml"));
            root = loder.load();
            LeaderBord controller = loder.getController();
            controller.ParentPane=ParentPane;
            controller.connection=connection;
            controller.ShowDashBoard();
            FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
            FideOut.play();
            FideOut.setOnFinished(e->{
                ParentPane.getChildren().remove(ChiledStage);
            });
            ParentPane.getChildren().add(root);
            new FadeInRightBig(root).play();

        } else {
            Error_Message.setText("Invalid Information Please Try Again");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Email_Area.setText("Admin@gmail.com");
        Password_Area.setText("admin");
    }
}
