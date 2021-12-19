package Controllers.Employer.Forms;

import java.io.IOException;

import Main.DataBaseConnection;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.control.Label;

public class Result {
    @FXML
    private Pane childPanex1;
    public DataBaseConnection connection;
    public Pane ParentPane;
    public Pane SearchFormPane;
    @FXML
    private Pane RoomDataPane;
    @FXML
    private VBox VboxRoom;
    private Pane DATAPANE;

    public void show_data_test() {
        System.out.println(SearchData.checkindate);
    }

    public void LoadSearchForm(ActionEvent e) throws IOException {
        Timeline timeline = new Timeline();
        SearchFormPane.setStyle("-fx-opacity:1");
        KeyValue kv = new KeyValue(SearchFormPane.translateXProperty(), 100, Interpolator.EASE_OUT);
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

    public void LoadClientForm(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Employer/Forms/Client.fxml"));
        Parent root = loader.load();
        Client controller = loader.getController();
        ParentPane.setStyle("-fx-background-color: #11111108");
        controller.connection = connection;
        controller.ParentPane = ParentPane;
        controller.ResultPane = childPanex1;
        root.translateXProperty().set(1024);
        ParentPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 100, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(childPanex1.translateXProperty(), -924, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }

    public void init() {
        VboxRoom.getChildren().remove(RoomDataPane);
        DATAPANE=(Pane) RoomDataPane.getChildren().get(0);
    }

    public void CreateLineRoom(String[] roomLine) {
        Pane RoomPane = new Pane();
        System.out.println(RoomDataPane.getChildren());
        RoomPane = DATAPANE;
        System.out.println("asdasdd"+RoomDataPane.getChildren());
        ((Label) RoomPane.getChildren().get(0)).setText(roomLine[0]);
        VboxRoom.getChildren().add(RoomPane);
        //RoomDataPane.getChildren().add(RoomPane);
    }
}