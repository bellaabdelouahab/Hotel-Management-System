package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Result implements Initializable {
    @FXML private Button testshow;
    @FXML private Pane ChildPane2;
    @FXML private VBox AccountMenu;
    @FXML private Button ProfileButton;

    public void AcountMenuShow(){
        AccountMenu.setVisible(true);
    }
    public void AcountMenuHide(){
        AccountMenu.setVisible(false);
    }
    public void show_data_test(){
        System.out.println(SearchData.checkindate);
    }
    public void Goback(ActionEvent e) throws IOException{
        Button backbutton = (Button)e.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        root.translateXProperty().set(-scene.getWidth());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(ChildPane2.translateXProperty(), -(root.translateXProperty().get()), Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(ChildPane2);
        });
        timeline.play();
    }
    public void ShowProfile1() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Employer/Authentification/Profile.fxml"));
        Scene scene = ProfileButton.getScene();
        root.translateXProperty().set(scene.getWidth());
        StackPane parentContainer = (StackPane)scene.getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}