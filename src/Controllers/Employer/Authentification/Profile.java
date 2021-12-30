package Controllers.Employer.Authentification;

import java.sql.*;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import Controllers.Employer.Forms.Methodes;
import io.github.gleidson28.GNAvatarView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import Main.DataBaseConnection;

public class Profile implements Initializable {
    @FXML
    private Pane ChildPane1;
    @FXML
    private GNAvatarView ProfilePicture;
    @FXML
    private TextField FullName, Sex, email, Adress, Age, Cin, Nationnality, Phonenumber;
    @FXML
    private GridPane PasswordForm;
    Image Image1;
    public DataBaseConnection connection;
    private String adr = "", natio = "", phone = "", cin = "", age = "", password = "";
    private int result = 0;

    @FXML
    private TextField new_pass, pass, check_pass;
    public String compte;
    BufferedImage ImagebBufferedImage;
    public GNAvatarView HomeProfilePicture;

    public void Goback(ActionEvent e) throws IOException {
        Button backbutton = (Button) e.getSource();
        Scene scene = backbutton.getScene();
        FlowPane parentContainer = (FlowPane) scene.getRoot();
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
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), -140, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }

    public void HidePassworkForm() {
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(this.PasswordForm.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
    }

    public void FileChooser() {
        ImagebBufferedImage = Methodes
                .ImageSaver();
        if (ImagebBufferedImage != null) {
            Image1 = SwingFXUtils.toFXImage(ImagebBufferedImage, null);
            ProfilePicture.setImage(Image1);
        } else {
            System.out.println("GMOV");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    public void FillProfileData() {
        try {
            ResultSet rs = connection.Login_employ(connection.getCompte().toLowerCase());
            while (rs.next()) {
                this.Cin.setText("JC"+String.valueOf(rs.getInt(1))+"598476");
                this.FullName.setText(rs.getString(2));
                this.Adress.setText(rs.getString(3));
                this.email.setText(rs.getString(4));
                this.Nationnality.setText(rs.getString(6));
                this.Phonenumber.setText(rs.getString(9));
                this.ProfilePicture.setImage(HomeProfilePicture.getImage());
                if (rs.getString(7).equals("h")) {
                    this.Sex.setText("Man");
                } else {
                    this.Sex.setText("Woman");
                }
                this.Age.setText(String.valueOf(rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("finawa ghadi \n" + e);
        }
    }

    @FXML
    public void update_info(ActionEvent event) throws Exception {
        ResultSet rs = connection.Login_employ(connection.getCompte().toLowerCase());
        while (rs.next()) {
            cin = String.valueOf(rs.getInt(1));
            adr = rs.getString(3);
            natio = rs.getString(6);
            phone = rs.getString(9);
            age = String.valueOf(rs.getInt(8));
            try{
            HomeProfilePicture.setImage(Image1);
            ImageIO.write(ImagebBufferedImage, "png", new
            File(System.getProperty("user.dir")
            + "\\src\\Resources\\IMAGES\\ProfilePictures\\" + connection.getCompte() +
            "te" + ".png"));
            }catch(Exception e){}
        }
        if (Adress.getText().toLowerCase().equals(adr) == false) {
            result = connection.adre_profile_change(Adress.getText().toLowerCase(), Integer.parseInt(cin));
            if (result > 0) {
                result = 0;
            } else {
                return;
            }
        }
        if (Nationnality.getText().toLowerCase().equals(natio) == false) {
            result = connection.natio_profile_change(Nationnality.getText().toLowerCase(), Integer.parseInt(cin));
            if (result > 0) {
                result = 0;
            } else {
                return;
            }
        }
        if (Phonenumber.getText().toLowerCase().equals(phone) == false) {
            result = connection.phone_profile_change(Phonenumber.getText().toLowerCase(), Integer.parseInt(cin));
            if (result > 0) {
                result = 0;
            } else {
                return;
            }
        }
        if (Age.getText().toLowerCase().equals(age) == false) {
            result = connection.age_profile_change(Integer.parseInt(Age.getText()), Integer.parseInt(cin));
            if (result > 0) {
                result = 0;
            } else {
                return;
            }
        } 
        Goback(event);
    }

    @FXML
    public void update_password(ActionEvent event) {
        System.out.println(connection.getCompte());
        cin = "";
        password = "";
        try {
            ResultSet rs = connection.Login_employ(connection.getCompte().toLowerCase());
            while (rs.next()) {
                cin = String.valueOf(rs.getInt(1));
                password = rs.getString(5);
            }
            if (pass.getText().equals(password)) {
                if (new_pass.getText().equals(check_pass.getText()) && new_pass.getText().length() >= 8) {
                    result = connection.change_password(new_pass.getText(), Integer.parseInt(cin));
                    if (result > 0) {
                        Goback(event);
                    } else {
                        System.out.println("hola");
                    }
                } else {
                    System.out.println("makhdemech pass word");
                    new_pass.setText("");
                    check_pass.setText("");
                }
            } else {
                pass.setStyle("-fx-border-color:red;");
                pass.setText("");
            }
        } catch (Exception e) {
            System.out.println("tr\n" + e);
        }
    }

}