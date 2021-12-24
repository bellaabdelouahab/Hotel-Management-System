package Controllers.Admin.Functions;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.sql.ResultSet;
import java.sql.SQLException;
import Main.DataBaseConnection;

public class DashBoardController{

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

    public DataBaseConnection connection;
    
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
}
