package Controllers.Admin.Functions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Controllers.Admin.Authentification.LoginController;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
public class LeaderBord implements{

    @FXML private VBox AdminMenu;

    @FXML private Pane LeaderBoardData;

    private Pane CurrentTab;

    public Pane ParentPane;

    public DataBaseConnection connection;

    @FXML
    void SwitchToProfile(MouseEvent event) throws IOException{
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Profile.fxml"));
        Parent root = loder.load();
        ProfileController controller = loder.getController();
        controller.LeaderBoardData=LeaderBoardData;
        controller.connection=connection;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            CurrentTab=(Pane) root;
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
        });
    }
    public void ShowDashBoard() throws IOException{
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/DashBoard.fxml"));
        Parent root = loder.load();
        DashBoardController controller = loder.getController();
        /////////////////////////// Use This To TRansefer Your Data ///////////////////////////////
        controller.connection=connection;
        ResultSet Resulta = controller.connection.ReturnCount("employee");
        try {

            controller.ROOM_ID.setText("200");
            controller.AMOUNT_ID.setText("4500");
            Resulta.next();
            controller.EMPLOYER_ID.setText(String.valueOf(Resulta.getInt("count(*)")));

        } catch (SQLException e) {
            System.out.println("WTF" +e);
        }
        
        // AdminMenu.setVisible(false);

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

        controller.AREACHART.getData().add(serie1);
        if(CurrentTab != null){
            FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
            FideOut.play();
            FideOut.setOnFinished(e->{
                LeaderBoardData.getChildren().remove(CurrentTab);
            });
        }
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
        });
    }
    public void SwitchToUser(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        Parent root = loder.load();
        UserController controller = loder.getController();
        controller.LeaderBoardData=LeaderBoardData;
        controller.connection=connection;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
            controller.CurrentTab=CurrentTab;
        });
        
    }

    @FXML
    void LogOut(MouseEvent event) throws IOException{
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Authentification/Login.fxml"));
        Parent root = loder.load();
        LoginController controller = loder.getController();
        controller.ParentPane=ParentPane;
        controller.connection=connection;
        if(CurrentTab != null){
            FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
            FideOut.play();
            FideOut.setOnFinished(e->{
                LeaderBoardData.getChildren().remove(CurrentTab);
                CurrentTab=(Pane) root;
            });
        }
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }

    @FXML
    void ShowMenuBar(MouseEvent event) {
        AdminMenu.setVisible(true);
    }

    @FXML
    void HideMenuBar(MouseEvent event) {
        AdminMenu.setVisible(false);
    }
}
