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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controllers.Admin.Authentification.LoginController;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;

public class DashBoardController{

    @FXML AreaChart<String, Double> AREACHART;

    @FXML
    private CategoryAxis AXIX;

    @FXML
    private NumberAxis AXIY;

    @FXML Label AMOUNT_ID;

    @FXML Label EMPLOYER_ID;

    @FXML Label ROOM_ID;

    // @FXML
    // private VBox AdminMenu;
    @FXML
    private AnchorPane ChiledStage;
    public Pane ParentPane;

    public DataBaseConnection connection;
}
