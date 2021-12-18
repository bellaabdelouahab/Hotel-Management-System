package Controllers.Employer.Forms;

import java.sql.*;
import java.util.Date;

import Main.DataBaseConnection;
import Main.info_reserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class reservation_page {

    public String compte;

    @FXML
    private Pane achno_reserv;

    @FXML
    private TableView<info_reserve> table_view;

    @FXML
    private TableColumn<info_reserve, Integer> cinCo;

    @FXML
    private TableColumn<info_reserve, Date> entrerCo;

    @FXML
    private TableColumn<info_reserve, Integer> etoileCo;

    @FXML
    private TableColumn<info_reserve, Integer> nbrCo;

    @FXML
    private TableColumn<info_reserve, String> nomCo;

    @FXML
    private TableColumn<info_reserve, Integer> prixCo;

    public DataBaseConnection connection;

    ObservableList<info_reserve> List_info = FXCollections.observableArrayList();

    private void affiche_table() {
        try {
            List_info.clear();
            ResultSet rs = connection.reserv(connection.getCompte().toLowerCase());
            while (rs.next()) {
                List_info.add(new info_reserve(rs.getInt("CIN"), rs.getString(2),rs.getInt("ID_ROOM"),rs.getInt("CLASSE"),rs.getDate("DATE_ENTRE"), rs.getInt("prix")));
                table_view.setItems(List_info);
            }
        } catch (Exception e) {
            System.out.println("aha ahmadi ach hada");
        }
    }

    public void init() {
        affiche_table();
        cinCo.setCellValueFactory(new PropertyValueFactory<info_reserve, Integer>("cin"));
        nomCo.setCellValueFactory(new PropertyValueFactory<info_reserve, String>("name"));
        nbrCo.setCellValueFactory(new PropertyValueFactory<info_reserve, Integer>("room"));
        etoileCo.setCellValueFactory(new PropertyValueFactory<info_reserve, Integer>("classe"));
        entrerCo.setCellValueFactory(new PropertyValueFactory<info_reserve, Date>("dateentre"));
        prixCo.setCellValueFactory(new PropertyValueFactory<info_reserve, Integer>("prix"));

        table_view.setItems(List_info);
    }


}