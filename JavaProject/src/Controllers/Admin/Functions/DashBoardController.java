package Controllers.Admin.Functions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable{

    @FXML
    private AreaChart<String, Double> AREACHART;

    @FXML
    private CategoryAxis AXIX;

    @FXML
    private NumberAxis AXIY;

    @FXML
    private Label AMOUNT_ID;

    @FXML
    private Label EMPLOYER_ID;

    @FXML
    private Label ROOM_ID;

    @FXML
    private VBox AdminMenu;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToUser(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void LogOut(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Authentification/Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ShowMenuBar(MouseEvent event) {
        AdminMenu.setVisible(true);
    }

    @FXML
    void HideMenuBar(MouseEvent event) {
        AdminMenu.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ROOM_ID.setText("200");
        AMOUNT_ID.setText("4500");
        EMPLOYER_ID.setText("176");

        AdminMenu.setVisible(false);

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
    @FXML
    void SwitchToProfile(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Profile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
