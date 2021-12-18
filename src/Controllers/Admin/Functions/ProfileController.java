package Controllers.Admin.Functions;

import Main.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProfileController{

    DataBaseConnection connection;
    
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
    public Pane ParentPane;
    
    @FXML
    public Pane LeaderBoardData;

    
    @FXML
    void UpdateProfile(ActionEvent event) {

        String Full_name = First_name.getText()+" "+Last_name.getText();;
        
        String Mail = Email.getText(); ;
        String Pass = Password.getText();
        String Con_pass = Con_password.getText();
        String Phon = Phone.getText();
        
        System.out.println(Pass);
        System.out.println(Con_pass);

        if(!String.valueOf(Pass).equals(String.valueOf(Con_pass))){
            Message.setText("Invalid Operation");
        }
        else{
            connection.UpdateProfile(Full_name, Mail, Pass, Phon);
            Message.setText("Profile Updated");
        }
    }
}
