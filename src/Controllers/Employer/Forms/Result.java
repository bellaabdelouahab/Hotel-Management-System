package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.DataBaseConnection;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Result implements Initializable {
    @FXML private Pane childPanex1;
    public DataBaseConnection connection;
    public Pane ParentPane;
    public Parent root;
    public Parent Resultroot;
    public Pane SearchFormPane;
    public void show_data_test(){
        System.out.println(SearchData.checkindate);
    }
    public void LoadSearchForm(ActionEvent e) throws IOException{
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(SearchFormPane.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(childPanex1.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            ParentPane.getChildren().remove(childPanex1);
        });
        timeline.play();
    }
    public void LoadClientForm(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Forms/Client.fxml"));
        Parent root = loader.load();
        Client controller = loader.getController();
        controller.connection=connection;
        controller.ParentPane=ParentPane;
        controller.ResultPane=childPanex1;
        root.translateXProperty().set(1024);
        root.translateYProperty().set(70);
        ParentPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(childPanex1.translateXProperty(), -924, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}