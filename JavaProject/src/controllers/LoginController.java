package controllers;

import java.sql.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/view/LogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/view/SignUp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField email_text;

    @FXML
    private ImageView image;

    @FXML
    private Line email_line, pass_line;

    // @FXML
    // private Pane image_login;

    @FXML
    private PasswordField password_label;

    @FXML
    private Button signin_btn;

    @FXML
    private Line line_e;

    @FXML
    private Button signup_btn;

    // hover de button sign in
    @FXML
    public void sign_in_hover() {
        // Stage btn_sign =(Stage) signin_btn.getScene().getWindow();
        String mod1 = "-fx-background-color:#5c00a3; -fx-background-radius:25;";
        signin_btn.setStyle(mod1);
    }

    @FXML
    public void sign_in_out() {
        // Stage btn_sign =(Stage) signin_btn.getScene().getWindow();
        String mod2 = "-fx-background-color: #009400; -fx-background-radius:25;";
        signin_btn.setStyle(mod2);
    }

    // hover de button sign up
    @FXML
    public void lign_hover() {
        signup_btn.setStyle("-fx-text-fill:#947e00; -fx-background-color: #292929;");
        line_e.setStyle("-fx-stroke-width:4; -fx-stroke:#947e00;");
    }

    @FXML
    public void lign_nonhover() {
        signup_btn.setStyle("-fx-text-fill:#fff; -fx-background-color: #292929;");
        line_e.setStyle("-fx-stroke-width:2; -fx-stroke:#fff;");
    }

    // hover sur le text area email and password
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

    // login
    @FXML
    public void login_formule() {
        // System.out.println(email_text.getText().contains("@gmail.com") + "\t" +
        // password_label.getText().length());
        String x="";
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
                    // System.out.println("no_etude \t" + rs.getString(1));
                    System.out.println("\t" + rs.getString(2).toLowerCase() + "\t" + password_label.getText().toLowerCase());
                    x=rs.getString(2).toLowerCase();
                    System.out.println(x.equals(password_label.getText()));
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
}
