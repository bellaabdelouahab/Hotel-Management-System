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

    @FXML AreaChart<String, Double> AREACHART;

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
        ResultSet Resulta = connection.ReturnCount("employee");
        try {

            ROOM_ID.setText("200");
            AMOUNT_ID.setText("4500");
            Resulta.next();
            EMPLOYER_ID.setText(String.valueOf(Resulta.getInt("count(*)")));

        } catch (SQLException e) {
            System.out.println("WTF" +e);
        }
        
        XYChart.Series<String , Double > serie1 = new XYChart.Series<String , Double>();
        serie1.setName("Amount");
        serie1.getData().add(new XYChart.Data<String , Double>("JAN" , 110.0));
        serie1.getData().add(new XYChart.Data<String , Double>("ASD" , 40.0));
        serie1.getData().add(new XYChart.Data<String , Double>("QLK" , 76.5));
        serie1.getData().add(new XYChart.Data<String , Double>("FSD" , 45.9));
        serie1.getData().add(new XYChart.Data<String , Double>("QWE" , 88.2));
        serie1.getData().add(new XYChart.Data<String , Double>("GHB" , 12.3));
        serie1.getData().add(new XYChart.Data<String , Double>("QWE" , 32.4));
        serie1.getData().add(new XYChart.Data<String , Double>("BGF" , 78.6));
        serie1.getData().add(new XYChart.Data<String , Double>("WER" , 79.8));
        serie1.getData().add(new XYChart.Data<String , Double>("JJJ" , 48.0));
        serie1.getData().add(new XYChart.Data<String , Double>("WER" , 65.12));

        AREACHART.getData().add(serie1);
    }
}
