package Controllers.Admin.Functions;

import java.io.IOException;
import Main.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class AddUserController {
    
    DataBaseConnection connection = new DataBaseConnection();

    @FXML
    private TextField Adresse;

    @FXML
    private TextField Age;

    @FXML
    private TextField Commission;

    @FXML
    private PasswordField Con_password;

    @FXML
    private TextField Email;

    @FXML
    private TextField First_name;

    @FXML
    private TextField Last_name;

    @FXML
    private Label Message;

    @FXML
    private TextField Nationality;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Phone;

    @FXML
    private TextField Salary;

    @FXML
    private ChoiceBox<?> Sex;

    @FXML
    private TextField Work_type;

    @FXML
    public Pane ParentPane;
    public Pane LeaderBoardData;

    @FXML
    void AddUser(ActionEvent event){
        try {
            String Full_name = First_name.getText() +" "+ Last_name.getText();;
            String Adress = Adresse.getText();
            String Mail = Email.getText();
            String Pass = Password.getText();
            //String Con_pass = Con_password.getText();
            String Natio = Nationality.getText();
            int Ag = Age.getAnchor();
            int sal = Salary.getAnchor();
            int comm = Commission.getAnchor();
            String Phon = Phone.getText();
            String work = Work_type.getText();
            connection.AddUsers(Full_name, Adress, Mail, Pass, Natio, Ag, Phon, sal, comm, work);
        } catch (Exception e) {
            System.out.println("Wtf" +e);
        }
    }

    void SwitchToUser(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        Scene scene;
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}