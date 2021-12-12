package Controllers.Employer.Authentification;

import java.sql.*;
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
    @FXML
    private Pane ChildPane1;
    @FXML
    private GNAvatarView ProfilePicture;
    @FXML
    private TextField FullName, Sex, email, Adress, Age, Cin, Nationnality, Phonenumber;
    @FXML
    private GridPane PasswordForm;

    private String adr = "", natio = "", sex = "", phone = "", nom = "", cin = "", mail = "", age = "",password="";

    Login m = new Login();
    private int result=0;

    @FXML
    private TextField new_pass,pass,check_pass;

    public void Goback(ActionEvent e) throws IOException {
        Button backbutton = (Button) e.getSource();
        Scene scene = backbutton.getScene();
        StackPane parentContainer = (StackPane) scene.getRoot();
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(ChildPane1.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(ChildPane1);
        });
        timeline.play();
    }

    public void ShowPassworkForm() {
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), -93, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }

    public void HidePassworkForm() {
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
        });
        timeline.play();
    }

    public void FileChooser() {
        Image savedImage = Methodes
                .ImageSaver(System.getProperty("user.dir") + "\\src\\Resources\\IMAGES\\ProfilePictures\\" + "te");
        if (savedImage != null)
            ProfilePicture.setImage(savedImage);
        else {
            System.out.println("GMOV");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("mmmm " + m.getCompte());
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                    "hotel");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from employee where lower(email)='" + m.getCompte().toLowerCase() + "'");
            while (rs.next()) {
                this.Cin.setText(String.valueOf(rs.getInt(1)));
                this.FullName.setText(rs.getString(2));
                this.Adress.setText(rs.getString(3));
                this.email.setText(rs.getString(4));
                this.Nationnality.setText(rs.getString(6));
                this.Phonenumber.setText(rs.getString(9));
                if (rs.getString(7) == "h") {
                    this.Sex.setText("femme");
                } else {
                    this.Sex.setText("homme");
                }
                this.Age.setText(String.valueOf(rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("finawa ghadi \n" + e);
        }
    }

    @FXML
    public void update_info(ActionEvent event) throws Exception {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                "hotel");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "select * from employee where lower(email)='" + m.getCompte().toLowerCase() + "'");
        while (rs.next()) {
            cin = String.valueOf(rs.getInt(1));
            nom = rs.getString(2);
            adr = rs.getString(3);
            mail = rs.getString(4);
            natio = rs.getString(6);
            phone = rs.getString(9);
            sex = rs.getString(7);
            age = String.valueOf(rs.getInt(8));
            password=rs.getString(5);
        }
        if (Adress.getText().toLowerCase().equals(adr) == false) {
            result = st.executeUpdate("update employee set adresse='" + Adress.getText().toLowerCase()
                    + "'where id_emp='" + Integer.parseInt(cin) + "'");
            if (result > 0) {
                System.out.println("oh yeah");
                //Goback(event);
                result = 0;
            } else {
                System.out.println("laaaaaaaaaa");
            }
        }
        if (Nationnality.getText().toLowerCase().equals(natio) == false) {
            result = st.executeUpdate("update employee set nationnality='" + Nationnality.getText().toLowerCase()
                    + "'where id_emp='" + Integer.parseInt(cin) + "'");
            if (result > 0) {
                System.out.println("oh yeah");
                //Goback(event);
                result = 0;
            } else {
                System.out.println("laaaaaaaaaa");
            }
        }
        if (Phonenumber.getText().toLowerCase().equals(phone) == false) {
            result = st.executeUpdate("update employee set phone_number='" + Phonenumber.getText().toLowerCase()
                    + "'where id_emp='" + Integer.parseInt(cin) + "'");
            if (result > 0) {
                System.out.println("oh yeah");
                //Goback(event);
                result = 0;
            } else {
                System.out.println("laaaaaaaaaa");
            }
        }
        if (Age.getText().toLowerCase().equals(age) == false) {
            result = st.executeUpdate("update employee set age='" + Integer.parseInt(Age.getText())
                    + "'where id_emp='" + Integer.parseInt(cin) + "'");
            if (result > 0) {
                System.out.println("oh yeah");
                //Goback(event);
                result = 0;
            } else {
                System.out.println("laaaaaaaaaa");
            }
        } else {
            System.out.println("oh non");
        }
    }

    @FXML
    public void update_password(ActionEvent event) throws Exception {
        if(pass.getText().equals(password)){
            if(new_pass.equals(check_pass) && new_pass.getText().length()>=8){
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                        "hotel");
                Statement st = con.createStatement();
                result = st.executeUpdate("update employee set password='" + new_pass.getText()
                    + "'where id_emp='" + Integer.parseInt(cin) + "'");
            }else{
                new_pass.setStyle("-fx-background-color:red;");
                check_pass.setStyle("-fx-background-color:red;");
                new_pass.setText("");
                check_pass.setText("");
            }
        }else{
            pass.setStyle("-fx-background-color:red;");
            pass.setText("");
        }
    }
}
