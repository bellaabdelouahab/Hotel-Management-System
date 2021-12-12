package Controllers.Employer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Home implements Initializable{
    @FXML
    private StackPane parentContainer;
    @FXML
    private VBox AccountMenu;
    @FXML
    private Button ProfileButton;
    private Parent root;
    public void AcountMenuShow() {
        AccountMenu.setVisible(true);
    }

    public void AcountMenuHide() {
        AccountMenu.setVisible(false);
    }

    public void ShowProfile() throws IOException{
        AcountMenuHide();
        Parent root = FXMLLoader.load(getClass().getResource("../../Resources/VIEW/Employer/Authentification/Profile.fxml"));
        root.translateXProperty().set(1024);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    public void ShowSearchForm() throws IOException{
        AcountMenuHide();
        this.root = FXMLLoader.load(getClass().getResource("../../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
        root.translateXProperty().set(1024);
        root.translateYProperty().set(70);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    public void ShowAboutPage() throws IOException{
        parentContainer.getChildren().remove(this.root);
        this.root = FXMLLoader.load(getClass().getResource("../../Resources/VIEW/Employer/About.fxml"));
        root.translateXProperty().set(0);
        root.translateYProperty().set(640);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 90, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ShowSearchForm();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
