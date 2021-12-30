package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private Label Error_Message;
    @FXML
    private Button B_ValidateForm1;
    @FXML
    private Pane SearchForm;
    public DataBaseConnection connection;
    public Pane ParentPane;
    @FXML
    private Label max_prix, outdate;

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

    public void ValidateForm1(ActionEvent e) {
        SearchData.checkindate = CheckInDate.getValue();
        SearchData.checkoutdate = CheckOutDate.getValue();
        SearchData.rating = RatingLable.getRating();
        if (MinPrice.getText() == "" || MinPrice.getText() == null)
            SearchData.minprice = 0;
        else {
            SearchData.minprice = Integer.parseInt(MinPrice.getText());
        }
        if (MaxPrice.getText() == "" || MaxPrice.getText() == null){
            SearchData.maxprice = SearchData.minprice+1000;
            MaxPrice.setText(String.valueOf(SearchData.maxprice));
        }
        else{
            SearchData.maxprice = Integer.parseInt(MaxPrice.getText());
        }
        SearchData.AdultsCounter = Integer.parseInt(AdultsNbr.getText());
        SearchData.CheldrenCounter = Integer.parseInt(CheldrenNbr.getText());
        if (SearchData.AdultsCounter == 0)return ;
        else if (CheckInDate.getValue().isAfter(CheckOutDate.getValue())) {
            CheckOutDate.setStyle(CheckOutDate.getStyle()+"-fx-background-color:#ff3333");
            return ;
        }
        else if (SearchData.maxprice == 0 || SearchData.maxprice < SearchData.minprice) {
            MaxPrice.setStyle(MaxPrice.getStyle()+"-fx-text-fill:#ff3333;");
            return ;
        }
        try {
            LoadResult(e);
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        }
    }

    public void ClearForm1() {
        CheckInDate.setValue(null);
        CheckOutDate.setValue(null);
        RatingLable.setRating(0);
        MaxPrice.setText(null);
        MinPrice.setText(null);
        AdultsNbr.setText("0");
        AdultsNbr.setText("0");
        AdultsNbr.setText("0");
    }
    
    public void LoadResult(ActionEvent e) throws IOException{
        ArrayList<String[]> RoomTableData= new ArrayList<String[]>();
        try{
        RoomTableData=GetSearchResult();
        }
        catch(Exception er){
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchResult.fxml"));
        Parent root = loader.load();
        Result controller = loader.getController();
        controller.connection = connection;
        controller.ParentPane = ParentPane;
        controller.datentrer = CheckInDate.getValue();
        controller.datesortir = CheckOutDate.getValue();
        controller.init();
        if (RoomTableData != null)
            for (String[] RoomLine : RoomTableData)
                controller.CreateLineRoom(RoomLine);
        controller.SearchFormPane = SearchForm;
        root.translateXProperty().set(1024);
        ParentPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 100, Interpolator.EASE_IN);
        KeyValue kv1 = new KeyValue(SearchForm.translateXProperty(), -924, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            ParentPane.getChildren().remove(SearchForm);
        });
        timeline.play();
    }
    private ArrayList<String[]> GetSearchResult() throws Exception {
        int INTData[]=new int[6];
        String StringData[]=new String[2];
        INTData[2]=(int)RatingLable.getRating();
        StringData[0]= CheckInDate.getValue().toString();
        StringData[1]= CheckOutDate.getValue().toString();
        try{
            System.out.println(StringData[0]);
            INTData[0] = Integer.parseInt(AdultsNbr.getText());
            INTData[1] = Integer.parseInt(CheldrenNbr.getText());
            INTData[3] = Integer.parseInt(MinPrice.getText());
            INTData[4] = Integer.parseInt(MaxPrice.getText());
        } catch (NumberFormatException e) {
            Error_Message.setText("Please enter a valid number");
            Error_Message.setStyle("-fx-background-color: #96242499;-fx-background-radius:50");
            throw new RuntimeException("MyError");
        }
        return connection.GetSearchedRoom(INTData, StringData);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LocalDate DateIn = LocalDate.now();//LocalDate.of(2020, 1, 8);
        CheckInDate.setValue(DateIn);
        LocalDate DateOut = LocalDate.now().plusDays(1);
        CheckOutDate.setValue(DateOut);

    }
}
