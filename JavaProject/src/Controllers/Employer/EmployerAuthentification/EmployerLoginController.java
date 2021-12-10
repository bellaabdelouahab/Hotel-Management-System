package Controllers.Employer.EmployerAuthentification;

import java.io.IOException;
import java.sql.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

public class EmployerLoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String compte;

    @FXML
    private TextField email_text;

    @FXML
    private Line email_line, pass_line;

    @FXML
    private Pane general_pane;

    @FXML
    private PasswordField password_label;

    @FXML
    private Button signin_btn;

    @FXML
    private AnchorPane achnopane;

    @FXML
    private Label pass_word;

    @FXML
    private Label emai_label;

    // Switch To Sign Up page of Employer
    @FXML
    public void SwitchToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass()
                .getResource("../../../Resources/VIEW/Employer/Authentification/EmployerSignUp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        String x = "", y = "";
        
        if (email_text.getText().contains("@gmail.com") && password_label.getText().length() != 8) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                        "hotel");
                Statement st = con.createStatement();
                System.out.println(email_text.getText().toLowerCase());
                ResultSet rs = st.executeQuery("select email,password from compte_employee where lower(email)='"
                        + email_text.getText().toLowerCase() + "'");
                while (rs.next()) {
                    System.out.println(
                            "\t" + rs.getString(2).toLowerCase() + "\t" + password_label.getText().toLowerCase());
                    x = rs.getString(2).toLowerCase();
                    y = rs.getString(1).toLowerCase();
                }
                if (y.equals(email_text.getText())) {
                    if (x.equals(password_label.getText())) {
                        try {
                            setCompte(y);
                            Parent root = FXMLLoader.load(
                                    getClass().getResource("../../../Resources/VIEW/Employer/Forms/SearchRoom.fxml"));
                            Scene scene = signin_btn.getScene();
                            root.translateXProperty().set(scene.getWidth());
                            achnopane.getChildren().add(root);
                            Timeline timeline = new Timeline();
                            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
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
                    } else {
                        pass_word.setStyle("-fx-text-fill:red;");
                        pass_line.setStyle("-fx-stroke:red;");
                    }
                } else {
                    emai_label.setStyle("-fx-text-fill:red;");
                    email_line.setStyle("-fx-stroke:red;");
                }

                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("ERREUR :( \n" + e);
            }
        } else {
            System.out.println("probleme");
        }
    }

    public void setCompte(String d){
        this.compte=d;
    }

    public String getCompte(){
        return this.compte;
    }
}
