package Controllers.Employer.Authentification;

import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Controllers.Employer.Forms.Methodes;
import io.github.gleidson28.GNAvatarView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Profile implements Initializable {
    @FXML private Pane ChildPane1;
    @FXML private GNAvatarView ProfilePicture;
    @FXML private TextField FullName;
    @FXML private TextField Adress;
    @FXML private TextField Age;
    @FXML private TextField Cin;
    @FXML private TextField Nationnality;
    @FXML private TextField Phonenumber;
    @FXML private GridPane PasswordForm;
    public void Goback(ActionEvent e) throws IOException{
        Button backbutton = (Button)e.getSource();
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane)scene.getRoot();
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(ChildPane1.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(ChildPane1);
        });
        timeline.play();
    }
    public void ShowPassworkForm(){
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), -93, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }
    public void HidePassworkForm(){
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
        });
        timeline.play();
    }
    public void FileChooser(){
        Image savedImage = Methodes.ImageSaver(System.getProperty("user.dir")+"\\src\\Resources\\IMAGES\\ProfilePictures\\"+"te");
        if(savedImage != null)
            ProfilePicture.setImage(savedImage);
        else{
            System.out.println("GMOV");
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        this.FullName.setText("are you good");
    }
}
