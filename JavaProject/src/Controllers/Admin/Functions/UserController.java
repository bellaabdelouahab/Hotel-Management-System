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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
public class UserController{

    DataBaseConnection connection = new DataBaseConnection();

    @FXML
    private TableView<User> USERSTABLE;

    @FXML
    private TableColumn<User, String> FULL_NAME;

    @FXML
    private TableColumn<User, String> ADRESSE;

    @FXML
    private TableColumn<User, String> EMAIL;

    @FXML
    private TableColumn<User, Integer> SALARY;

    @FXML
    private TableColumn<User, Integer> COMMISSION;

    @FXML
    private TableColumn<User, String> WORK_TYPE;

    public Pane CurrentTab;

    @FXML
    public Pane LeaderBoardData;

    void init() {    
        ResultSet Lest = connection.GetAllEmployers();    
        ObservableList<User> List = FXCollections.observableArrayList();
        try {
            
            while(Lest.next()){            
                List.add(new User(Lest.getInt("ID_EMP") , Lest.getString("FULL_NAME") , Lest.getString("PASSWORD") , Lest.getString("ADRESSE") , Lest.getInt("SALAIRE") , Lest.getInt("COMMISSION") , Lest.getString("type_travaille"))); 
            };  

        } catch (SQLException e) {
            System.out.println("No Data Found"+e);
        }
        
        FULL_NAME.setCellValueFactory(new PropertyValueFactory<User , String>("FullName"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<User , String>("Adresse"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<User , String>("Email"));
        SALARY.setCellValueFactory(new PropertyValueFactory<User , Integer>("Salary"));
        COMMISSION.setCellValueFactory(new PropertyValueFactory<User , Integer>("Commission"));
        WORK_TYPE.setCellValueFactory(new PropertyValueFactory<User , String>("WorkType"));

        USERSTABLE.setItems(List);
    }

    @FXML
    void DeleteUser(MouseEvent event) throws IOException{
        User test = USERSTABLE.getSelectionModel().getSelectedItem();
        connection.DeleteUser(test.getId());
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        Parent root = loder.load();
        UserController controller = loder.getController();
        controller.connection=connection;
        controller.init();
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
            controller.CurrentTab=CurrentTab;
        });
    }

    @FXML
    public void GoToModify(ActionEvent event) throws IOException{

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/ModifyUser.fxml"));

        //root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/ModifyUser.fxml"));
        // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }

    @FXML
    void SwitchToAddUser(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        Parent root = loder.load();
        AddUserController controller = loder.getController();
        controller.LeaderBoardData = LeaderBoardData;
        controller.connection=connection;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            CurrentTab=(Pane) root;
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root; 
        });
    }

}
