package Controllers.Admin.Functions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Main.Amount;
import Main.DataBaseConnection;

public class DashBoardController implements Initializable{

    @FXML
    private TableView<Amount> AMOUNTTABLE;

    ObservableList<Amount> List = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Amount, String> DATE;

    @FXML
    private TableColumn<Amount, Integer> AMOUNT;

    @FXML AreaChart<String, Integer> AREACHART;

    @FXML
    private CategoryAxis AXIX;

    @FXML
    private NumberAxis AXIY;

    @FXML Label AMOUNT_ID;

    @FXML Label EMPLOYER_ID;

    @FXML Label ROOM_ID;
    
    @FXML
    private AnchorPane ChiledStage;
    
    public Pane ParentPane;

    DataBaseConnection connection = new DataBaseConnection();
    
    public void init(){

        ResultSet EmResult = connection.ReturnCount("employee");
        ResultSet RmResult = connection.ReturnCount("rooms");
        ResultSet ClResult = connection.ReturnCount("client");

        try {

            while(RmResult.next()){
                ROOM_ID.setText(String.valueOf(RmResult.getInt("count(*)")));
                ClResult.next();
                AMOUNT_ID.setText(String.valueOf(ClResult.getInt("count(*)")));
                EmResult.next();
                EMPLOYER_ID.setText(String.valueOf(EmResult.getInt("count(*)")));
            }

        } catch (SQLException e) {
            System.out.println("WTF" +e); 
        }
        ResultSet DashResult = connection.DashBoardData();
        XYChart.Series<String , Integer > serie1 = new XYChart.Series<String , Integer>();
        serie1.setName("Amount");
        try {
            while(DashResult.next()){
                serie1.getData().add(new XYChart.Data<String , Integer>(DashResult.getString("DATE_DE_RESERVER").substring(0,11) , DashResult.getInt("PRIX")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        AREACHART.getData().add(serie1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ResultSet AmountResult = connection.DashBoardData();

        try {
            while (AmountResult.next()) {
                List.add(new Amount(AmountResult.getString("DATE_DE_RESERVER").substring(0,11) , AmountResult.getInt("PRIX")));
            }
        } catch (SQLException e) {
            System.out.println("not Working "+e);
        }    
        
        DATE.setCellValueFactory(new PropertyValueFactory<Amount , String>("Date"));        
        AMOUNT.setCellValueFactory(new PropertyValueFactory<Amount , Integer>("Amount"));

        AMOUNTTABLE.setItems(List);
        
    }
}
