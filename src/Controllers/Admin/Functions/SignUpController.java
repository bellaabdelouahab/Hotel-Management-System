package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Main.DataBaseConnection;
import Main.SignUp;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SignUpController implements Initializable{

    DataBaseConnection connection = new DataBaseConnection();

    ObservableList<SignUp> List = FXCollections.observableArrayList();

    @FXML
    private TableColumn<SignUp, String> ADRESSE;

    @FXML
    private Pane ChildPane;

    @FXML
    private TableColumn<SignUp, String> EMAIL;

    @FXML
    private TableColumn<SignUp, String> FIRST_NAME;

    @FXML
    private TableColumn<SignUp, String> LAST_NAME;

    @FXML
    private TableColumn<SignUp, String> NATIONALITY;

    @FXML
    private TableColumn<SignUp, String> NUMBER;

    @FXML
    private TableView<SignUp> SIGNUPTABLE;

    public Pane ParentPane;

    public Pane CurrentTab;

    @FXML
    private Pane LeaderBoardData;

    @FXML
    void AddReservation(MouseEvent event) throws SQLException, IOException {
        SignUp test = SIGNUPTABLE.getSelectionModel().getSelectedItem();
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        Parent root = loder.load();
        AddUserController controller = loder.getController();
        controller.item = test;
        controller.connection=connection;
        controller.init();
        FadeOutLeft FideOut =new FadeOutLeft(ChildPane);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(ChildPane);
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }

    @FXML
    void DeleteReservation(MouseEvent event) {
        SignUp test = SIGNUPTABLE.getSelectionModel().getSelectedItem();
        connection.DeleteReservation(test.getId());
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ResultSet Lest = connection.GetSignUpInformation();

        try {
            while (Lest.next()) {
                List.add(new SignUp(Lest.getInt("id") , Lest.getString("first_name"), Lest.getString("last_name") ,Lest.getString("adresse") , Lest.getString("email") ,Lest.getString("nationality") , Lest.getString("phone_number")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }
  
        FIRST_NAME.setCellValueFactory(new PropertyValueFactory<SignUp , String>("First_Name"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<SignUp , String>("Last_Name"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<SignUp , String>("Adresse"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<SignUp , String>("Email"));
        NATIONALITY.setCellValueFactory(new PropertyValueFactory<SignUp , String>("Natio"));
        NUMBER.setCellValueFactory(new PropertyValueFactory<SignUp , String>("Number"));

        SIGNUPTABLE.setItems(List);
        
    }

}
