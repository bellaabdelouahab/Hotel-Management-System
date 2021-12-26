package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Main.DataBaseConnection;
import Main.Rooms;
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

public class RoomsController implements Initializable{

    @FXML Pane ChildPane;

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

    public Pane CurrentTab;

    public Pane ParentPane;

    @FXML
    private Pane LeaderBoardData;

    @FXML
    void SwitchToModifyRoom(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/ModifyRoom.fxml"));
        Parent root = loder.load();
        Rooms test = ROOMSTABLE.getSelectionModel().getSelectedItem();
        ModifyRoomController controller = loder.getController();
        controller.item = test.getId_room();
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
    void DeleteRoom(MouseEvent event) {
        Rooms test = ROOMSTABLE.getSelectionModel().getSelectedItem();
        connection.DeleteRoom(test.getId_room());
    }

    @FXML
    void SwitchToAdd(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddRooms.fxml"));
        Parent root = loder.load();
        AddRoomController controller = loder.getController();
        controller.ChildPane = ChildPane;
        controller.connection = connection;
        FadeOutLeft FideOut = new FadeOutLeft(ChildPane);
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
