package Controllers.Employer.Forms;

import java.io.IOException;

import org.controlsfx.control.Rating;

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
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Result{
    @FXML private Pane childPanex1;
    public DataBaseConnection connection;
    public Pane ParentPane;
    public Pane SearchFormPane;
    @FXML private VBox VboxRoom;
    public void show_data_test(){
        System.out.println(SearchData.checkindate);
    }
    public void LoadSearchForm(ActionEvent e) throws IOException{
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
    public void LoadClientForm(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Forms/Client.fxml"));
        Parent root = loader.load();
        Client controller = loader.getController();
        ParentPane.setStyle("-fx-background-color: #11111108");
        controller.connection=connection;
        controller.ParentPane=ParentPane;
        controller.ResultPane=childPanex1;
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
    }
    public void CreateLineRoom(String[] roomLine) {
        Pane RoomPane =new Pane();
        RoomPane.setPrefSize(824, 80);
        Label IdLabel = Create_Label("Room ID",112,40,0,0);
        Label IdData = Create_Label(roomLine[0],112,40,112,0);
        Label Price = Create_Label("Room ID",112,40,0,40);
        Label PriceData = Create_Label(roomLine[1],112,40,112,40);
        Label AdultsNbr = Create_Label("Room ID",150,40,224,0);
        Label AdultsNbrData = Create_Label(roomLine[2],112,40,374,0);
        Label ChildrenNbr = Create_Label("Room ID",150,40,224,40);
        Label ChildrenNbrData = Create_Label(roomLine[3],112,40,374,40);
        Button Reserve = new Button("Reserve");
        Reserve.setPrefSize(179, 46);
        Reserve.setLayoutX(645);
        Reserve.setLayoutY(33);
        Reserve.setStyle("-fx-background-radius:0");
        Rating RatingData = new Rating();
        // RatingData.setPrefSize(179, 46);
        RatingData.setLayoutX(645);
        RatingData.setLayoutY(0);
        Pane HideRating = new Pane();
        HideRating.setPrefSize(179, 46);
        HideRating.setLayoutX(645);
        HideRating.setLayoutY(0);
        Line Separatuer = new Line();
        Separatuer.setStrokeWidth(4);
        Separatuer.setStartY(80);
        Separatuer.setEndY(80);
        Separatuer.setEndX(824);
        RoomPane.getChildren().addAll(IdLabel,IdData,Price,PriceData,AdultsNbr,AdultsNbrData,ChildrenNbr,ChildrenNbrData,Reserve,RatingData,HideRating,Separatuer);
        VboxRoom.getChildren().add(RoomPane);
    }
    private Label Create_Label(String Name,double Xsize,double Ysize,double Xlayout,double Ylayoyt) {
        Label IdLabel = new Label(Name);
        IdLabel.setPrefSize(Xsize, Ysize);
        IdLabel.setLayoutX(Xlayout);
        IdLabel.setLayoutY(Ylayoyt);
        IdLabel.setStyle("-fx-background-color:#eeeeee11;");
        return IdLabel;
    }
}