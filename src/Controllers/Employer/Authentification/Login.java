package Controllers.Employer.Authentification;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.controlsfx.control.MaskerPane;

import Controllers.Employer.Home;
import Main.DataBaseConnection;
import animatefx.animation.FadeIn;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
public class Login{
    private String compte;

    @FXML
    public TextField email_text;

    @FXML
    private Line email_line, pass_line;

    @FXML
    private Pane general_pane;

    @FXML
    public PasswordField password_label;

    @FXML
    private Button signin_btn,signup_btn;

    @FXML AnchorPane achnopane;

    @FXML
    private Label pass_word;

    @FXML
    private Label emai_label;
    @FXML
    private ImageView image_login;
    public DataBaseConnection connection;
    public Pane ParentPane;
    public ArrayList<String> request;

    // Switch To Sign Up page of Employer
    @FXML
    public void SwitchToSignUp(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Authentification/SignUp.fxml"));
        Parent root = loader.load();
        SignUp controller = loader.getController();
        controller.connection=connection;
        controller.achnopane= achnopane;
        achnopane.getChildren().clear();
        achnopane.getChildren().add(root);
        new FadeIn(root).play();
    }

    @FXML
    public void lign_input_mail() {
        if (email_text.getText().contains("@gmail.com")) {
            email_line.setStyle("-fx-stroke:green;");
        } else {
            if (email_text.getText() == "") {
                email_line.setStyle("-fx-stroke:#fff;");
            } else {
                email_line.setStyle("-fx-stroke:red;");
            }
        }
    }

    @FXML
    public void lign_input_pass() {
        if (password_label.getText().length() == 0) {
            pass_line.setStyle("-fx-stroke:#fff;");
        } else {
            if (password_label.getText().length() < 8) {
                pass_line.setStyle("-fx-stroke:red;");
            } else {
                pass_line.setStyle("-fx-stroke:green;");
            }
        }
    }

    @FXML
    public void login_formule(ActionEvent event) {
        MaskerPane login_animation = new MaskerPane();
        login_animation.setText("Connecting");
        login_animation.setProgress(-1);
        login_animation.setLayoutX(450);
        login_animation.setLayoutY(256);
        String x = "", y = "";
        if (email_text.getText().contains("@gmail.com") && password_label.getText().length() >= 8) {
            StartConnection(login_animation, x, y);
        } else {
            emai_label.setStyle("-fx-text-fill:red;");
            email_line.setStyle("-fx-stroke:red;");
            pass_word.setStyle("-fx-text-fill:red;");
            pass_line.setStyle("-fx-stroke:red;");
        }
    }

    private void StartConnection(MaskerPane login_animation, String x, String y) {
        achnopane.getChildren().add(login_animation);
        Timeline timeline1 = new Timeline();
        KeyValue kvs = new KeyValue(login_animation.progressProperty(),-1, Interpolator.EASE_IN);
        KeyFrame kfs = new KeyFrame(Duration.seconds(1), kvs);
        timeline1.getKeyFrames().add(kfs);
        try {
            ResultSet rs = connection.Login_employ(email_text.getText().toLowerCase());
            
            while (rs.next()) {
                y = rs.getString(4).toLowerCase();
                x = rs.getString(5).toLowerCase();
            }
            if (y.equals(email_text.getText())) {
                if (x.equals(password_label.getText())) {
                    connection.AddEmailToHistory(email_text.getText());
                    connection.setCompte(y);
                    timeline1.setOnFinished(ep->{
                        achnopane.getChildren().remove(login_animation);
                        SwitchToHomePage();
                    });
                    timeline1.play();
                    //sdfsda
                } else {
                    achnopane.getChildren().remove(login_animation);
                    pass_word.setStyle("-fx-text-fill:red;");
                    pass_line.setStyle("-fx-stroke:red;");
                }
        
            } else {
                achnopane.getChildren().remove(login_animation);
                emai_label.setStyle("-fx-text-fill:red;");
                email_line.setStyle("-fx-stroke:red;");
            }
            
        } catch (Exception e) {
            System.out.println("ERREUR :( \n" + e);
        }
    }

    private void SwitchToHomePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/HomePage.fxml"));
            Scene scene = signin_btn.getScene();
            Parent root = loader.load();
            Home controller = loader.getController();
            controller.connection=connection;
            controller.compte = compte;
            controller.achnopane= achnopane;
            controller.init();
            root.translateXProperty().set(scene.getWidth());
            achnopane.getChildren().add(root);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0,Interpolator.EASE_IN);
            KeyValue kv1 = new KeyValue(general_pane.translateXProperty(),
            -(root.translateXProperty().get()), Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
            timeline.getKeyFrames().add(kf);
            timeline.getKeyFrames().add(kf1);
            timeline.setOnFinished(t -> {
                achnopane.getChildren().remove(general_pane);
            });
            
            timeline.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
