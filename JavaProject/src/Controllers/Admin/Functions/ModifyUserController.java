package Controllers.Admin.Functions;

import Main.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ModifyUserController {

    @FXML
    public Pane ParentPane;
    public Pane LeaderBoardData;

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
    void ModifyUser(ActionEvent event) {

        String First_names = First_name.getText();
        String Adress = Adresse.getText();
        String Mail = Email.getText();
        String Pass = Password.getText();
        String Natio = Nationality.getText();
        int ag = Age.getAnchor();
        String Phon = Phone.getText();
        int sal = Salary.getAnchor();
        int Comm = Commission.getAnchor();
        String Type = Work_type.getText();
        connection.ModifyUser(First_names, Adress, Mail, Pass, Natio, ag, Phon, sal, Comm, Type,   2);
    
    }

    @FXML
    void SwitchToDashBoard(MouseEvent event) {

    }

}