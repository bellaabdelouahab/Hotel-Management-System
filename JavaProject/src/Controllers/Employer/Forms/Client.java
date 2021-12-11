package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.controlsfx.control.CheckComboBox;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Client implements Initializable{
    @FXML private Pane ChildPaneXS;
    @FXML private CheckComboBox<String> RoomFeatures;
    public void LoadResultForm(ActionEvent e) throws IOException{
        Button backbutton = (Button)e.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchResult.fxml"));
        root.translateXProperty().set(-1024);
        root.translateYProperty().set(70);
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(ChildPaneXS.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(ChildPaneXS);
        });
        timeline.play();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        final ObservableList<String> checkcomboboxelements = FXCollections.observableArrayList();
        String[] list = {"coffee Morning","Wifi 5G","Sofa","Cushion","Telephone","Television","Speaker","End table","Tea set","Fireplace","Remote","Fan","Floor lamp","Carpet","Tableet Blinds"};
        for(int i = 0; i<list.length; i++){
        checkcomboboxelements.add(list[i]);
        }
        RoomFeatures.getItems().addAll(checkcomboboxelements);
    }
}
