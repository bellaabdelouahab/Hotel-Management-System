package Controllers.Admin.Functions;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import Main.DataBaseConnection;
import Main.User;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
public class UserController{

    DataBaseConnection connection;

    private Parent root;
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
    public Pane CurrentTab;
    @FXML
    public Pane LeaderBoardData;
    public Pane ChildUser;

    void init() {    
        ResultSet Lest = connection.GetAllEmployers();    
        ObservableList<User> List = FXCollections.observableArrayList();
        try {
            
            while(Lest.next()){            
                List.add(new User(Lest.getInt("ID_EMP") , Lest.getString("FULL_NAME") , Lest.getString("PASSWORD") , Lest.getString("ADRESSE") , Lest.getInt("SALAIRE") , Lest.getInt("COMMISSION"))); 
            };  

        } catch (SQLException e) {
            System.out.println("No Data Found");
        }
        
            // AdminMenu.setVisible(false);
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
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        root = loder.load();
        AddUserController controller = loder.getController();
        controller.LeaderBoardData=LeaderBoardData;
        FadeOutLeft FideOut =new FadeOutLeft(ChildUser);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(ChildUser);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            ChildUser=(Pane) root;
            controller.ChildUser=ChildUser;
        });
    }
}
