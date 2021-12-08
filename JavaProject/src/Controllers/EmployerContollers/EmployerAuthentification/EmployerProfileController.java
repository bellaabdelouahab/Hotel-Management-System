package Controllers.EmployerContollers.EmployerAuthentification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class EmployerProfileController implements Initializable {
    public void Goback(ActionEvent e) throws IOException{
        Button backbutton = (Button)e.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/Form_1.fxml"));
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        root.translateXProperty().set(-scene.getWidth()/2);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), root.translateXProperty().get(), Interpolator.EASE_OUT);
        Node ChildPane = null;
        KeyValue kv1 = new KeyValue(ChildPane.translateXProperty(), -(root.translateXProperty().get()), Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(root);
        });
        timeline.play();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

    }
}
