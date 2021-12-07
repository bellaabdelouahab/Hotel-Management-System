package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Main.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminControllers implements Initializable{

    @FXML
    private TableView<User> USERSTABLE;

    @FXML
    private TableColumn<User, Integer> ID;

    @FXML
    private TableColumn<User, String> NAME;

    @FXML
    private TableColumn<User, String> LAST_NAME;

    @FXML
    private TableColumn<User, String> ADRESSE;

    @FXML
    private TableColumn<User, Integer> SALARY;

    @FXML
    private TableColumn<User, Integer> COMMISSION;

    public ObservableList<User> List = FXCollections.observableArrayList(
        new User(1 , "Hamza", "Bouslama" , "KHOURIBGA" , 1500 , 300),
            new User(1 , "Hamza", "Hamza" , "KHOURIBGA" , 1500 , 300)

    ); 

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ID.setCellValueFactory(new PropertyValueFactory<User , Integer>("id"));
        NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<User , String>("Adresse"));
        SALARY.setCellValueFactory(new PropertyValueFactory<User , Integer>("Salary"));
        COMMISSION.setCellValueFactory(new PropertyValueFactory<User , Integer>("Commission"));

        USERSTABLE.setItems(List);
    }
}
