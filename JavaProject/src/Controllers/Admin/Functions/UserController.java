package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Main.DataBaseConnection;
import Main.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class UserController implements Initializable{

    DataBaseConnection connection = new DataBaseConnection();
    ResultSet Lest = connection.GetAllEmployers();    
    ObservableList<User> List = FXCollections.observableArrayList();

    @FXML
    private VBox AdminMenu;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToDashBoard(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/DashBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SwitchToProfile(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Profile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    void HideMenuBar(MouseEvent event) {
        AdminMenu.setVisible(false);
    }

    @FXML
    private TableView<User> USERSTABLE;

    @FXML
    private TableColumn<User, Integer> ID;

    @FXML
    private TableColumn<User, String> NAME;

    @FXML
    private TableColumn<User, String> LAST_NAME;

    @FXML
    private TableColumn<User, String> ADRESSE;

    @FXML
    private TableColumn<User, Integer> SALARY;

    @FXML
    private TableColumn<User, Integer> COMMISSION;

    @Override
    public void initialize(URL location, ResourceBundle resources){
    
    try {
        
        while(Lest.next()){            
            List.add(new User(Lest.getInt("ID_EMP") , Lest.getString("FULL_NAME") , Lest.getString("PASSWORD") , Lest.getString("ADRESSE") , Lest.getInt("SALAIRE") , Lest.getInt("COMMISSION"))); 
        };  

    } catch (SQLException e) {
        System.out.println("No Data Found");
    }
    
        AdminMenu.setVisible(false);
        ID.setCellValueFactory(new PropertyValueFactory<User , Integer>("id"));
        NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Last"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<User , String>("Adresse"));
        SALARY.setCellValueFactory(new PropertyValueFactory<User , Integer>("Salary"));
        COMMISSION.setCellValueFactory(new PropertyValueFactory<User , Integer>("Commission"));

        USERSTABLE.setItems(List);
    }

    @FXML
    void DeleteUser(MouseEvent event) {
    }

    @FXML
    void SwitchToAddUser(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
