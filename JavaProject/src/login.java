import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class login {

    @FXML
    private TextField email_text;

    @FXML
    private ImageView image;

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
}
