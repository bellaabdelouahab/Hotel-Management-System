package Controllers.Admin.Functions;

import java.net.URL;
import java.util.ResourceBundle;
import Main.Client;
import Main.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController implements Initializable{

    DataBaseConnection connection = new DataBaseConnection();
    
    @FXML
    private TableColumn<Client, Integer> AGE;

    @FXML
    private TableColumn<Client, Integer> AMOUNT;

    @FXML
    private TableColumn<Client, String> CIN;

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

    @FXML
    private TableView<Client> CLIENTTABLE;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        
    }

}
