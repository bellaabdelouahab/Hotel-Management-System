package Controllers.Admin.Functions;

import java.io.IOException;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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

    @FXML
    public Pane LeaderBoardData;

    @FXML
    public Pane ChildPane;

    @FXML
    public Pane ChildPane2;

    @FXML
    void AddUser(ActionEvent event) {
        try {
            String Full_name = First_name.getText() + " " + Last_name.getText();
            System.out.println(Full_name);
            String Adress = Adresse.getText();
            String Mail = Email.getText();
            String Pass = Password.getText();
            // String Con_pass = Con_password.getText();
            String Natio = Nationality.getText();
            int Ag = Integer.parseInt(Age.getText());
            int sal = Integer.parseInt(Salary.getText());
            int comm = Integer.parseInt(Commission.getText());
            String Phon = Phone.getText();
            String work = Work_type.getText();
            connection.AddUsers(Full_name, Adress, Mail, Pass, Natio, Ag, Phon, sal, comm, work);
            SwitchToUser(event);
        } catch (Exception e) {
            System.out.println("Wtf" + e);
        }
    }

    void SwitchToUser(ActionEvent event) throws IOException {

        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        Parent root = loder.load();
        UserController controller = loder.getController();
        controller.connection = connection;
        controller.init();
        FadeOutLeft FideOut = new FadeOutLeft(ChildPane2);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(ChildPane2);

        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            ChildPane2 = (Pane) root;
            controller.CurrentTab = ChildPane2;
        });

    }
}