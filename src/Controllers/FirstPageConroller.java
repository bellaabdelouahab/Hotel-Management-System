package Controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import Controllers.Admin.Authentification.LoginController;
import Controllers.Employer.Authentification.Login;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import animatefx.animation.Jello;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class FirstPageConroller implements Initializable{
    DataBaseConnection Connection=new DataBaseConnection();
    private Parent root;
    @FXML
    private Pane ParentPane;
    @FXML
    private Pane ChiledStage;
    @FXML
    private Pane header;
    @FXML 
    private Polygon Polygona;
    @FXML
    private Rectangle Rectan;
    // Switch To Admin Page
    public void SwitchToAdminPage(ActionEvent event) throws IOException {
        try{
        Properties Prop = new Properties();
        OutputStream config = new FileOutputStream(System.getProperty("user.dir") + "/src/Config.properties");
        Prop.setProperty("MainPage", "1");
        Prop.store(config, "");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        returnHeaderBlack();
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../Resources/VIEW/Admin/Authentification/Login.fxml"));
        root = loder.load();
        LoginController controller = loder.getController();
        controller.ParentPane=ParentPane;
        controller.connection=Connection;
        FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
        FideOut.play();
        FideOut.setOnFinished(e->{
            ParentPane.getChildren().remove(ChiledStage);
        });
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }

    // Switch To Employer Page
    public void SwitchToEmployerPage(ActionEvent event) throws IOException, SQLException {
        try{
            Properties Prop = new Properties();
            OutputStream config = new FileOutputStream(System.getProperty("user.dir") + "/src/Config.properties");
            Prop.setProperty("MainPage", "2");
            Prop.store(config, "");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        returnHeaderBlack();
        Button Btton=(Button)((Node)event.getSource());
        Btton.setDisable(true);
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        root = loder.load();
        Login controller = loder.getController();
        controller.connection=Connection;
        AutoCompletionBinding<String> autoComplete=TextFields.bindAutoCompletion(controller.email_text, Connection.GetEmailesHistory());
        autoComplete.prefWidthProperty().bind(controller.email_text.widthProperty());
        FadeOutLeft FideOut =new FadeOutLeft(ChiledStage);
        FideOut.play();
        FideOut.setOnFinished(e->{
            ParentPane.getChildren().remove(ChiledStage);
            Btton.setDisable(false);
        });
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }
    public void CloseWindow() {
        Connection.Disconnect();
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.close();
    }
    public void ExitHover(MouseEvent event){
        new Jello((Node) event.getSource()).play();
        ((Button) event.getSource()).setStyle("-fx-background-color:#f70a0a");
    }
    public void ExitHoverOut(MouseEvent event){
        ((Button) event.getSource()).setStyle("-fx-background-color: #00000000");
    }
    public void MinimizeWindow(){
        Stage stage = (Stage)ParentPane.getScene().getWindow();
        stage.setIconified(true);
    }
    public void returnHeaderBlack(){
        new FadeOutLeft(Rectan).play();
        new FadeOutLeft(Polygona).play();
        header.getChildren().remove(Rectan);
        header.getChildren().remove(Polygona);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    /////The only Place To initialize The DataBase connection
    Connection.ConnectToDataBase();
    }
}
