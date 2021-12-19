package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ModifyUserController implements Initializable{

    @FXML
    private Pane ChildPane3;

    @FXML
    public Pane ParentPane;

    @FXML
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
    private ComboBox<String> Sex;

    @FXML
    private TextField Work_type;
    public int item;
    
    public String[] SexType = {"M" , "W"};

    @FXML
    void ModifyUser(ActionEvent event) throws IOException {

        String Full_name = First_name.getText()+Last_name.getText();
        String Adress = Adresse.getText();
        String Mail = Email.getText();
        String Pass = Password.getText();
        String Natio = Nationality.getText();
        String Se = Sex.getValue();
        int ag = Integer.parseInt(Age.getText());
        String Phon = Phone.getText();
        int sal = Integer.parseInt(Salary.getText());
        int Comm = Integer.parseInt(Commission.getText());
        String Type = Work_type.getText();
        connection.ModifyUser(Full_name, Adress, Mail, Pass, Natio, Se, ag, Phon, sal, Comm, Type, item);
        SwitchToUser(event);
    }
    
    void SwitchToUser(ActionEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        Parent root = loder.load();
        UserController controller = loder.getController();
        controller.connection=connection;
        controller.init();
        FadeOutLeft FideOut =new FadeOutLeft(ChildPane3);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(ChildPane3);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            ChildPane3=(Pane) root;
            controller.CurrentTab=ChildPane3;
        });
    }

    @FXML
    void SwitchToDashBoard(MouseEvent event) {

    }

    public void init() throws SQLException {
        
        ResultSet Result = connection.ModifyInfo(item);
        while(Result.next()){
            Adresse.setText(Result.getString("adresse"));
            Email.setText(Result.getString("email"));
            Nationality.setText(Result.getString("nationnality"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Sex.setPromptText("SEX");
        Sex.getItems().addAll(SexType);
    }
}