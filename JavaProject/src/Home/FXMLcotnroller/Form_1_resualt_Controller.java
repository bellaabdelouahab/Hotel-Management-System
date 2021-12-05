package Home.FXMLcotnroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;




public class Form_1_resualt_Controller implements Initializable {
    @FXML private Button testshow;
    @FXML private Pane ChildPane;
    public void show_data_test(){
        System.out.println(Form1_Data.checkindate);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}