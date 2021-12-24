package Controllers.Admin.Functions;

import java.io.IOException;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ModifyRoomController {

    DataBaseConnection connection = new DataBaseConnection();

    public String[] MoreType = { "coffee Morning", "Wifi 5G", "Cushion", "Television", "Speaker", "End table", "Tea set","Fireplace", "Floor lamp", "Tableet Blinds" };

    @FXML
    private Pane ChildPane;

    @FXML
    private Pane LeaderBoardData;
    
    @FXML
    private TextField NUM_ADULT;

    @FXML
    private TextField NUM_CHILD;

    @FXML
    private TextField PRIC;

    @FXML
    private TextField ROOM_CLASS;

    @FXML
    private ComboBox<String> ROOM_FUTER;

    public Pane CurrentTab;

    public int item;

    @FXML
    void ModifyRoom(ActionEvent event) throws IOException {

        int Adult = Integer.parseInt(NUM_ADULT.getText());
        int Child = Integer.parseInt(NUM_CHILD.getText());
        int Class = Integer.parseInt(ROOM_CLASS.getText());
        int Pric  = Integer.parseInt(PRIC.getText());
        String MORE = ROOM_FUTER.getValue();
        connection.ModifyRoom(Adult, Child, Class, Pric, MORE , item);
        SwitchToAdd(event);

    }

    void SwitchToAdd(ActionEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/Rooms.fxml"));
        Parent root = loder.load();
        RoomsController controller = loder.getController();
        controller.ChildPane = ChildPane;
        controller.connection = connection;
        FadeOutLeft FideOut = new FadeOutLeft(ChildPane);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(ChildPane);
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }
    
    public void init(){
        ROOM_FUTER.setPromptText("ROOM FEATURES");
        ROOM_FUTER.getItems().addAll(MoreType);
    }
}
