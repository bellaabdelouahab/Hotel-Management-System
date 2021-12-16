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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Result implements Initializable {
    @FXML private Pane childPanex1;
    public void show_data_test(){
        System.out.println(SearchData.checkindate);
    }
    public void LoadSearchForm(ActionEvent e) throws IOException{
        Button backbutton = (Button)e.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
        root.translateXProperty().set(-1024);
        root.translateYProperty().set(70);
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(childPanex1.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(childPanex1);
        });
        timeline.play();
    }
    public void LoadClientForm(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Employer/Forms/Client.fxml"));
        root.translateXProperty().set(924);
        root.translateYProperty().set(70);
        Scene scene = ((Node) e.getSource()).getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(childPanex1.translateXProperty(), -924, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(childPanex1);
        });
        timeline.play();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}