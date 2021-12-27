package Controllers.Admin.Functions;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Main.DataBaseConnection;
import Main.reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ReservationController implements  Initializable{

    @FXML
    private TableColumn<reservation, Integer> ID_RESERVATION;

    @FXML
    private TableColumn<reservation, String> CHECK_IN;

    @FXML
    private TableColumn<reservation, String> CHECK_OUT;

    @FXML
    private TableColumn<reservation, Integer> ID_CLIENT;

    @FXML
    private TableColumn<reservation, Integer> ID_ROOM;

    @FXML
    private TableColumn<reservation,Integer> ID_EMP;

    @FXML
    private TableView<reservation> RESERVATIONTABLE;

    DataBaseConnection connection = new DataBaseConnection();

    ObservableList<reservation> List = FXCollections.observableArrayList();

    public Pane CurrentTab;

    public Pane ParentPane;

    @FXML
    private Pane LeaderBoardData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ResultSet Lest = connection.GetReservationInformation();

        try {
            while (Lest.next()) {
                List.add(new reservation(Lest.getInt("id_reserv"), Lest.getString("date_de_reserver").substring(0,11) , Lest.getString("date_de_sortir").substring(0,11),Lest.getInt("id_client") ,Lest.getInt("id_emp"),Lest.getInt("ID_ROOM")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }
        
        ID_RESERVATION.setCellValueFactory(new PropertyValueFactory<reservation , Integer>("Id_reservation"));
        CHECK_IN.setCellValueFactory(new PropertyValueFactory<reservation , String>("dateentre"));
        CHECK_OUT.setCellValueFactory(new PropertyValueFactory<reservation , String>("datesortir"));
        ID_CLIENT.setCellValueFactory(new PropertyValueFactory<reservation , Integer>("id_client"));
        ID_EMP.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("id_emp"));
        ID_ROOM.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("Id_room"));

        RESERVATIONTABLE.setItems(List);

    }





















}
