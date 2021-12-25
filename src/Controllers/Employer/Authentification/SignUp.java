package Controllers.Employer.Authentification;

import java.io.IOException;
import java.util.ArrayList;
import Main.DataBaseConnection;
import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class SignUp {
    private ArrayList<String> requet=new ArrayList<String>();
    @FXML
    private TextField mail, user, phone ;
    @FXML
    private PasswordField pass , confirme_pass ;
    public DataBaseConnection connection;
    public AnchorPane achnopane;
    // Switch To Sign 
    @FXML
    public void SwitchToSignIn(ActionEvent event) throws IOException {
        achnopane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        Parent root = loader.load();
        Login controller = loader.getController();
        controller.connection=connection;
        controller.achnopane= achnopane;
        achnopane.getChildren().add(root);
        new FadeIn(root).play();
    }
    // add to data base
    @FXML
    public void login_return(ActionEvent event) throws Exception {
        if(user.getText().length()!=0 && mail.getText().contains("@gmail.com")){
            requet.add(user.getText());
            requet.add(mail.getText());
            if(phone.getText().length()>0 && phone.getText().length()<16){
                requet.add(phone.getText());
            }
        }
    }
}
