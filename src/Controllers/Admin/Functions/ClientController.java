package Controllers.Admin.Functions;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Main.Client;
import Main.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientController implements Initializable{

    ObservableList<Client> List = FXCollections.observableArrayList();


    DataBaseConnection connection = new DataBaseConnection();
    
    @FXML
    private TableColumn<Client, Integer> AGE;

    @FXML
    private TableColumn<Client, String> AMOUNT;

    @FXML
    private TableColumn<Client, String> CIN;

    @FXML
    private TableView<Client> CLIENTTABLE;

    @FXML
    private TableColumn<Client, String> FIRST_NAME;

    @FXML
    private TableColumn<Client, String> GEND;

    @FXML
    private TableColumn<Client, String> LAST_NAME;

    @FXML
    private TableColumn<Client, String> NATIO;

    @FXML
    private TableColumn<Client, String> SITU;


    @Override
    public void initialize(URL location, ResourceBundle resources){


        ResultSet Lest = connection.GetClientInformation();

        try {
            while (Lest.next()) {
                List.add(new Client(Lest.getString("id_client"), Lest.getString("first_name"),Lest.getString("last_name"),Lest.getString("nationality") ,Lest.getString("gender"),Lest.getString("etat_civil"),Lest.getInt("age")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }    
        
        CIN.setCellValueFactory(new PropertyValueFactory<Client , String>("Cin"));
        FIRST_NAME.setCellValueFactory(new PropertyValueFactory<Client ,  String>("Firstname"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<Client , String>("Lastname"));
        NATIO.setCellValueFactory(new PropertyValueFactory<Client ,String>("Natio"));
        GEND.setCellValueFactory(new PropertyValueFactory<Client , String>("Gender"));
        SITU.setCellValueFactory(new PropertyValueFactory<Client , String>("Situ"));
        AGE.setCellValueFactory(new PropertyValueFactory<Client ,  Integer>("Age"));


        CLIENTTABLE.setItems(List);

    
    }

}
