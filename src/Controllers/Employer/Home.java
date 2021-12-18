package Controllers.Employer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.SQLException;

import org.controlsfx.control.textfield.TextFields;

import animatefx.animation.FadeIn;
import Controllers.Employer.Authentification.Login;
import Controllers.Employer.Authentification.Profile;
import Controllers.Employer.Forms.Search;
import Controllers.Employer.Forms.reservation_page;
import Main.DataBaseConnection;
import io.github.gleidson28.GNAvatarView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Home {
    @FXML
    private Pane parentContainer;
    @FXML
    private VBox AccountMenu;
    @FXML
    private GNAvatarView ProfilePicture;
    @FXML
    private Button ProfileButton, reservation_label;
    private Parent root;
    public DataBaseConnection connection;
    public String compte;
    @FXML
    public Pane HomePane;
    public AnchorPane achnopane;

    public void AcountMenuShow() {
        AccountMenu.setVisible(true);
    }

    public void AcountMenuHide() {
        AccountMenu.setVisible(false);
    }
    public void ReturnToHome() {
        HomePane.getChildren().clear();
        try {
            ShowSearchForm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowProfile() throws IOException {
        AcountMenuHide();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../../Resources/VIEW/Employer/Authentification/Profile.fxml"));
        Parent root = loader.load();
        Profile controller = loader.getController();
        controller.connection = connection;
        controller.compte = compte;
        controller.HomeProfilePicture = ProfilePicture;
        controller.FillProfileData();
        root.translateXProperty().set(1024);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    public void ShowSearchForm() throws IOException {
        AcountMenuHide();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
        this.root = loader.load();
        Search controller = loader.getController();
        controller.connection=connection;
        controller.ParentPane=HomePane;
        root.translateXProperty().set(1024);
        HomePane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 100, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    public void ShowAboutPage() throws IOException {
        HomePane.getChildren().clear();
        this.root = FXMLLoader.load(getClass().getResource("../../Resources/VIEW/Employer/About.fxml"));
        this.root.translateXProperty().set(0);
        this.root.translateYProperty().set(640);
        HomePane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    public void init() {
        UpdateProfilePic();
    }

    private void UpdateProfilePic() {
        try {
            this.ProfilePicture.setImage(new Image(System.getProperty("user.dir")
                    + "\\src\\Resources\\IMAGES\\ProfilePictures\\" + connection.getCompte() + "te.png"));
            ShowSearchForm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void reservation(ActionEvent e) throws Exception {
        HomePane.getChildren().clear();
        AcountMenuHide();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../../Resources/VIEW/Employer/Forms/reservation.fxml"));
        Parent root = loader.load();
        if (parentContainer.getChildren().contains(root)) {
            return;
        }
        reservation_page controller = loader.getController();
        controller.connection = connection;
        controller.compte = compte;
        controller.init();
        root.translateXProperty().set(1024);
        root.translateYProperty().set(70);
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    public void LogOut() throws IOException, SQLException{
        achnopane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        Parent root = loader.load();
        Login controller = loader.getController();
        controller.connection=connection;
        TextFields.bindAutoCompletion(controller.email_text, connection.GetEmailesHistory());
        achnopane.getChildren().add(root);
        new FadeIn(root).play();
    }
}
