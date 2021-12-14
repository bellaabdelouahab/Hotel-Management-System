package Controllers.Admin.Functions;

import java.io.IOException;

import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class AddUserController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
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
    public Pane CurrentTab;
    public Pane LeaderBoardData;


    @FXML
    void AddUser(ActionEvent event) throws IOException {
        
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
        
        SwitchToUser(event);
    }
    void SwitchToUser(ActionEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        root = loder.load();
        UserController controller = loder.getController();
        controller.LeaderBoardData=LeaderBoardData;
        controller.CurrentTab=CurrentTab;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
        });
    }
}