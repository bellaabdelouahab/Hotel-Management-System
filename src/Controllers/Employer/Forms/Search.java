package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
//Make sure you have added the lib from reference library
import org.controlsfx.control.Rating;

import Main.DataBaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Search implements Initializable {
    @FXML
    private Pane ChildPane;
    @FXML
    private GridPane NbrOfPersons;
    @FXML
    private Label AdultsNbr;
    @FXML
    private Label AdultsNbrLable;
    @FXML
    private Label CheldrenNbr;
    @FXML
    private Label CheldrenNbrLable;
    @FXML
    private Label RoomsNbr;
    @FXML
    private Label RoomsNbrLable;
    @FXML
    private DatePicker CheckInDate;
    @FXML
    private DatePicker CheckOutDate;
    @FXML
    private Rating RatingLable;
    @FXML
    private TextField MinPrice;
    @FXML
    private TextField MaxPrice;
    @FXML
    private Button B_ValidateForm1;
    @FXML 
    private Pane SearchForm;
    public DataBaseConnection connection;
    public StackPane ParentPane;

    // private String pattern = "dd-MM-yyyy";s

    public void showNbrOfPersons() {
        if (NbrOfPersons.visibleProperty().get())
            NbrOfPersons.setVisible(false);
        else
            NbrOfPersons.setVisible(true);
    }

    public void incAdultsNbr() {
        if (Integer.parseInt(AdultsNbr.getText()) < 10) {
            int AdultsCounter = Integer.parseInt(AdultsNbr.getText());
            AdultsCounter++;
            AdultsNbr.setText("" + AdultsCounter);
            AdultsNbrLable.setText("" + AdultsCounter);
        }
    }

    public void incCheldrenNbr() {
        if (Integer.parseInt(CheldrenNbr.getText()) < 10) {
            int ChheldrenCounter = Integer.parseInt(CheldrenNbr.getText());
            ChheldrenCounter++;
            CheldrenNbr.setText("" + ChheldrenCounter);
            CheldrenNbrLable.setText("" + ChheldrenCounter);
        }
    }

    public void incRoomsNbr() {
        if (Integer.parseInt(RoomsNbr.getText()) < 10) {
            int RoomsCounter = Integer.parseInt(RoomsNbr.getText());
            RoomsCounter++;
            RoomsNbr.setText("" + RoomsCounter);
            RoomsNbrLable.setText("" + RoomsCounter);
        }
    }

    public void decAdultsNbr() {
        if (Integer.parseInt(AdultsNbr.getText()) > 0) {
            int AdultsCounter = Integer.parseInt(AdultsNbr.getText());
            AdultsCounter--;
            AdultsNbr.setText("" + AdultsCounter);
            AdultsNbrLable.setText("" + AdultsCounter);
        }

    }

    public void decCheldrenNbr() {
        if (Integer.parseInt(CheldrenNbr.getText()) > 0) {
            int ChheldrenCounter = Integer.parseInt(CheldrenNbr.getText());
            ChheldrenCounter--;
            CheldrenNbr.setText("" + ChheldrenCounter);
            CheldrenNbrLable.setText("" + ChheldrenCounter);
        }
    }

    public void decRoomsNbr() {
        if (Integer.parseInt(RoomsNbr.getText()) > 0) {
            int RoomsCounter = Integer.parseInt(RoomsNbr.getText());
            RoomsCounter--;
            RoomsNbr.setText("" + RoomsCounter);
            RoomsNbrLable.setText("" + RoomsCounter);
        }
    }

    public void ValidateForm1(ActionEvent e) {
        SearchData.checkindate = CheckInDate.getValue();
        SearchData.checkoutdate = CheckOutDate.getValue();
        SearchData.rating = RatingLable.getRating();
        if (MaxPrice.getText() == "" || MaxPrice.getText() == null)
            SearchData.maxprice = 0;
        else
            SearchData.maxprice = Integer.parseInt(MaxPrice.getText());
        if (MinPrice.getText() == "" || MinPrice.getText() == null)
            SearchData.minprice = 0;
        else
            SearchData.minprice = Integer.parseInt(MinPrice.getText());
            SearchData.AdultsCounter = Integer.parseInt(AdultsNbr.getText());
            SearchData.CheldrenCounter = Integer.parseInt(AdultsNbr.getText());
            SearchData.RoomsCounter = Integer.parseInt(AdultsNbr.getText());
        /* Put Your Shitey Code Here : form 1 */

        try {
            LoadResult(e);
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        }
    }

    public void ClearForm1() {
        CheckInDate.setValue(null);
        ;
        CheckOutDate.setValue(null);
        RatingLable.setRating(0);
        MaxPrice.setText(null);
        MinPrice.setText(null);
        AdultsNbr.setText("0");
        AdultsNbr.setText("0");
        AdultsNbr.setText("0");
    }
    
    public void LoadResult(ActionEvent e) throws IOException{
        GetSearchResult();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchResult.fxml"));
        Parent root = loader.load();
        Result controller = loader.getController();
        controller.connection=connection;
        controller.ParentPane=ParentPane;
        controller.SearchFormPane=SearchForm;
        controller.Resultroot=root;
        root.translateXProperty().set(1024);
        root.translateYProperty().set(70);
        ParentPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyValue kv1 = new KeyValue(SearchForm.translateXProperty(), -924, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }
    private void GetSearchResult() throws IOException{
        
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LocalDate date = LocalDate.of(2020, 1, 8);
        CheckInDate.setValue(date);

    }
}
