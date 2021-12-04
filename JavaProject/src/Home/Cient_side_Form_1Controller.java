package Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.controlsfx.control.Rating;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
public class Cient_side_Form_1Controller implements Initializable {
    @FXML private StackPane parentContainer;
    @FXML private Pane ChildPane;
    @FXML private GridPane NbrOfPersons;
    @FXML private Label AdultsNbr;
    @FXML private Label AdultsNbrLable;
    @FXML private Label CheldrenNbr;
    @FXML private Label CheldrenNbrLable;
    @FXML private Label RoomsNbr;
    @FXML private Label RoomsNbrLable;
    @FXML private DatePicker CheckInData;
    @FXML private DatePicker CheckOutData;
    @FXML private Rating RatingLable; 
    @FXML private TextField MinPrice;
    @FXML private TextField MaxPrice;
    @FXML private Button B_ValidateForm1;

    public void showNbrOfPersons(){
        if(NbrOfPersons.visibleProperty().get())
            NbrOfPersons.setVisible(false);
        else 
            NbrOfPersons.setVisible(true);
    }
    public void incAdultsNbr(){
        int AdultsCounter = Integer.parseInt(AdultsNbr.getText());
        AdultsCounter++;
        AdultsNbr.setText(""+AdultsCounter);
        AdultsNbrLable.setText(""+AdultsCounter);
    }
    public void incCheldrenNbr(){
        int ChheldrenCounter = Integer.parseInt(CheldrenNbr.getText());
        ChheldrenCounter++;
        CheldrenNbr.setText(""+ChheldrenCounter);
        CheldrenNbrLable.setText(""+ChheldrenCounter);
    }
    public void incRoomsNbr(){
        int RoomsCounter = Integer.parseInt(RoomsNbr.getText());
        RoomsCounter++;
        RoomsNbr.setText(""+RoomsCounter);
        RoomsNbrLable.setText(""+RoomsCounter);
    }
    public void decAdultsNbr(){
        int AdultsCounter = Integer.parseInt(AdultsNbr.getText());
        AdultsCounter--;
        AdultsNbr.setText(""+AdultsCounter);
        AdultsNbrLable.setText(""+AdultsCounter);

    }
    public void decCheldrenNbr(){
        int ChheldrenCounter = Integer.parseInt(CheldrenNbr.getText());
        ChheldrenCounter--;
        CheldrenNbr.setText(""+ChheldrenCounter);
        CheldrenNbrLable.setText(""+ChheldrenCounter);
    }
    public void decRoomsNbr(){
        int RoomsCounter = Integer.parseInt(RoomsNbr.getText());
        RoomsCounter--;
        RoomsNbr.setText(""+RoomsCounter);
        RoomsNbrLable.setText(""+RoomsCounter);
    }
    public void ValidateForm1(){
        Form1_Data.checkindate=CheckInData.getValue();
        Form1_Data.checkoutdate = CheckOutData.getValue();
        Form1_Data.rating = RatingLable.getRating();
        Form1_Data.maxprice = Integer.parseInt(MaxPrice.getText());
        Form1_Data.minprice = Integer.parseInt(MinPrice.getText());
        Form1_Data.AdultsCounter = Integer.parseInt(AdultsNbr.getText());
        Form1_Data.CheldrenCounter = Integer.parseInt(AdultsNbr.getText());
        Form1_Data.RoomsCounter = Integer.parseInt(AdultsNbr.getText());
        /* Put Your Shitey Code Here : form 1  */

        try {
            loadSecond();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ClearForm1(){
        CheckInData.setValue(null);;
        CheckOutData.setValue(null);
        RatingLable.setRating(0);
        MaxPrice.setText(null);
        MinPrice.setText(null);
        AdultsNbr.setText(null);
        AdultsNbr.setText(null);
        AdultsNbr.setText(null);
    }
    
    private void loadSecond() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Client_side_Form_1_resualt.fxml"));
        Scene scene = B_ValidateForm1.getScene();
        root.translateXProperty().set(scene.getWidth());

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(ChildPane);
        });
        timeline.play();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
