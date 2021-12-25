package Controllers.Admin.Functions;

import java.net.URL;
import java.util.ResourceBundle;

import Main.Client;
import Main.DataBaseConnection;
//import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController implements Initializable{

    //private static final ObservableList<Client> List = null;

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
        try {
            System.out.println(1/0);
            
        } catch (Exception e) {
            System.out.println("Aji saweb had teb");
            System.exit(1);
        }
    //     ResultSet Lest = connection.GetClientInformation();

    //     try {
    //         while (Lest.next()) {
    //             List.add(new Client(Lest.getString("id_client"), Lest.getString("first_name"),  Lest.getString(" last_name "), Lest.getString("nationality") , Lest.getString("gender"),Lest.getString(" etat_civil "),Lest.getInt(" age")));
    //         }
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
        
    //     CIN.setCellValueFactory(new PropertyValueFactory<Client , String>("Cin"));
    //     FIRST_NAME.setCellValueFactory(new PropertyValueFactory<Client ,  String>("Firstname"));
    //     LAST_NAME.setCellValueFactory(new PropertyValueFactory<Client , String>("Lastname"));
    //     NATIO.setCellValueFactory(new PropertyValueFactory<Client ,String>("Natio"));
    //     GEND.setCellValueFactory(new PropertyValueFactory<Client , String>("Gender"));
    //     SITU.setCellValueFactory(new PropertyValueFactory<Client , String>("Situ"));
    //     AGE.setCellValueFactory(new PropertyValueFactory<Client ,  Integer>("Age"));


    //     CLIENTTABLE.setItems(List);

    
    }

}
