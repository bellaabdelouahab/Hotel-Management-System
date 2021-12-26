package Controllers.Admin.Functions;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controllers.Employer.Forms.reservation_page;
import Main.DataBaseConnection;
import Main.reservation;
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

public class ReservationController implements  Initializable{
    @FXML
    private TableColumn<reservation, Date> CHECK_IN;

    @FXML
    private TableColumn<reservation, Date> CHECK_OUT;


    @FXML
    private TableView<reservation> RESERVATIONTABLE;

    @FXML
    private TableColumn<reservation, String> ID_CLIENT;

    @FXML
    private TableColumn<Reservation,Integer> ID_EMP;

    @FXML
    private TableColumn<Reservation, String> ID_RESERVATION;

    @FXML
    private TableColumn<Reservation, Integer> ID_ROOM;

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
                List.add(new reservation(Lest.getString("ID_RESERVATION"), Lest.getDate("CHECK_IN"), Lest.getDate("CHECK_OUT"),Lest.getString("ID_CLIENT") ,Lest.getInt("ID_EMP"),Lest.getInt("ID_ROOM")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }
        
        ID_RESERVATION.setCellValueFactory(new PropertyValueFactory<reservation , String>("last_name"));
        CHECK_IN.setCellValueFactory(new PropertyValueFactory<reservation , Date>("date_de_reserver"));
        CHECK_OUT.setCellValueFactory(new PropertyValueFactory<reservation , Date>("date_de_sortir"));
        ID_CLIENT.setCellValueFactory(new PropertyValueFactory<reservation , String>("id_client"));
        ID_EMP.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("id_emp"));
        ID_ROOM.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("ID_ROOM"));

        RESERVATIONTABLE.setItems(List);

    }





















}
