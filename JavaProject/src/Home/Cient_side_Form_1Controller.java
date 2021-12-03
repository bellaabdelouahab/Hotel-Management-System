package Home;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Cient_side_Form_1Controller implements Initializable {
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
        LocalDate checkindate = CheckInData.getValue();
        LocalDate checkoutdate = CheckOutData.getValue();
        double rating = RatingLable.getRating();
        double maxprice = Integer.parseInt(MaxPrice.getText());
        double minprice = Integer.parseInt(MinPrice.getText());
        int AdultsCounter = Integer.parseInt(AdultsNbr.getText());
        int CheldrenCounter = Integer.parseInt(AdultsNbr.getText());
        int RoomsCounter = Integer.parseInt(AdultsNbr.getText());
        System.out.println(checkindate+"\n"+checkoutdate+"\n"+rating+"\n"+minprice+"\n"+maxprice+"\n"+AdultsCounter+"\n"+CheldrenCounter+"\n"+RoomsCounter);
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
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
