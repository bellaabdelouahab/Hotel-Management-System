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
    private TableColumn<User, String> ADRESSE;

    @FXML
    private TableColumn<User, Integer> COMMISSION;

    @FXML
    private TableColumn<User, Integer> ID;

    @FXML
    private TableColumn<User, String> LAST_NAME;

    @FXML
    private TableColumn<User, String> NAME;

    @FXML
    private TableColumn<User, Integer> SALARY;

    @FXML
    private TableView<User> USERSTABLE;

    ObservableList<User> List = FXCollections.observableArrayList(
        new User(1 , "Hamza", "Bouslama" , "KHOURIBGA" , 1500 , 300)
    ); 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<User , Integer>("Name"));
        NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<User , String>("Name"));
        SALARY.setCellValueFactory(new PropertyValueFactory<User , Integer>("Name"));
        COMMISSION.setCellValueFactory(new PropertyValueFactory<User , Integer>("Name"));

        USERSTABLE.setItems(List);
    }

}
