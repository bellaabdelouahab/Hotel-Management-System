package Controllers.Employer.Forms;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;

import Controllers.Employer.Authentification.Login;
//import Main.connection;
import Main.info_reserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class reservation_page {// implements Initializable {

    // @FXML
    // private Pane achno_reserv;

    // @FXML
    // private VBox vbox_reser;
    // private connection x = new connection();
    // private Login l = new Login();

    // ObservableList<info_reserve> List = FXCollections.observableArrayList();

    // @FXML
    // private TableColumn<info_reserve, Integer> cin;

    // @FXML
    // private TableColumn<info_reserve, Integer> classe;

    // @FXML
    // private TableColumn<info_reserve, Date> date_entre;

    // @FXML
    // private TableColumn<info_reserve, String> name;

    // @FXML
    // private TableColumn<info_reserve, Integer> prix;

    // @FXML
    // private TableColumn<info_reserve, Integer> room;

    // @FXML
    // private TableView<info_reserve> table_view;

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    // ResultSet rs = x.reserv(l.getCompte().toLowerCase());
    // System.out.println("hhhhhhhhhh" + l.getCompte().toLowerCase());
    // try {
    // while (rs.next()) {
    // table_view.getItems().add(new info_reserve(rs.getInt(1), rs.getString(2),
    // rs.getInt(3),rs.getInt(4), rs.getDate(5),rs.getInt(6)));
    // // System.out.println(rs.getInt(1) + "\n" + rs.getString(2) + "\n" +
    // // rs.getInt(3));
    // //List.add(new info_reserve(rs.getInt(1), rs.getString(2),
    // rs.getInt(3),rs.getInt(4), rs.getDate(5),rs.getInt(6)));
    // }
    // } catch (SQLException e) {
    // System.out.println("No Data Found");
    // }
    // for (int i = 0; i < List.size(); i++) {
    // table_view.getItems().add(List.get(i));
    // }

    // AdminMenu.setVisible(false);
    // cin.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // Integer>("cin"));
    // name.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // String>("name"));
    // room.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // Integer>("room"));
    // classe.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // Integer>("classe"));
    // date_entre.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // Date>("date_entre"));
    // prix.setCellValueFactory(new PropertyValueFactory<info_reserve,
    // Integer>("prix"));

    // table_view.setItems(List);
    // }

}
