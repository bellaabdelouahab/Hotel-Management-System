package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ProfileController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    DataBaseConnection connection = new DataBaseConnection();
    
    @FXML
    private Label Message;

    @FXML
    private PasswordField Con_password;

    @FXML
    private TextField Email;

    @FXML
    private TextField First_name;

    @FXML
    private TextField Last_name;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Phone;
    
    @FXML
    private VBox AdminMenu;

    @FXML
    void HideMenuBar(MouseEvent event) {
        AdminMenu.setVisible(false);
    }

    @FXML
    void LogOut(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Authentification/Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ShowMenuBar(MouseEvent event) {
        AdminMenu.setVisible(true);
    }

    @FXML
    void SwitchToUser(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AdminMenu.setVisible(false);
    }
    
    @FXML
    void UpdateProfile(ActionEvent event) {

        String Full_name = First_name.getText()+" "+Last_name.getText();;
        
        String Mail = Email.getText(); ;
        String Pass = Password.getText();
        String Con_pass = Con_password.getText();
        String Phon = Phone.getText();
        
        System.out.println(Pass);
        System.out.println(Con_pass);

        if(String.valueOf(Pass) != String.valueOf(Con_pass)){
            Message.setText("Invalid Operation");
        }
        else{
            connection.UpdateProfile(Full_name, Mail, Pass, Phon);
            Message.setText("Profile Updated");
        }
    }
}
