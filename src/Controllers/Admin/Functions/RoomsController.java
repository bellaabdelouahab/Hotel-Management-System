package Controllers.Admin.Functions;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Main.DataBaseConnection;
import Main.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RoomsController implements Initializable{

    @FXML
    private TableColumn<Rooms, Integer> ADULT;

    @FXML
    private TableColumn<Rooms, Integer> CHILDREN;

    @FXML
    private TableColumn<Rooms, Integer> CLASSE;

    @FXML
    private TableColumn<Rooms, Integer> ID_ROOM;

    @FXML
    private TableColumn<Rooms, Integer> PRICE;

    @FXML
    private TableView<Rooms> ROOMSTABLE;

    DataBaseConnection connection = new DataBaseConnection();

    ObservableList<Rooms> List = FXCollections.observableArrayList();

    @FXML
    private Pane ChildPane;

    public Pane CurrentTab;

    public Pane ParentPane;

    @FXML
    void DeleteUser(MouseEvent event) {

    }

    @FXML
    void GoToModify(MouseEvent event) {

    }

    @FXML
    void SwitchToAddUser(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ResultSet Lest = connection.GetRoomsInformation();

        try {
            while (Lest.next()) {
                List.add(new Rooms(Lest.getInt("ID_ROOM"), Lest.getInt("NUM_ADUL"), Lest.getInt("NUM_CHILD"),Lest.getInt("CLASSE") ,Lest.getInt("PRIX")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }
        
        ID_ROOM.setCellValueFactory(new PropertyValueFactory<Rooms , Integer>("Id_room"));
        ADULT.setCellValueFactory(new PropertyValueFactory<Rooms , Integer>("Adulte"));
        CHILDREN.setCellValueFactory(new PropertyValueFactory<Rooms , Integer>("Children"));
        CLASSE.setCellValueFactory(new PropertyValueFactory<Rooms , Integer>("Classe"));
        PRICE.setCellValueFactory(new PropertyValueFactory<Rooms , Integer>("Price"));

        ROOMSTABLE.setItems(List);

    }


}
