package Controllers.Employer.Authentification;

import java.io.IOException;
import java.net.URL;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import Main.DataBaseConnection;
import animatefx.animation.FadeIn;
import java.util.*;
public class SignUp implements Initializable{
    
    @FXML
    private Label sended;
    
    @FXML
    private TextField mail, phone ,address,age,first_name,last_name,natio;
    @FXML
    private ComboBox<String> sex;
    @FXML
    private Line line1,line2,line3,line4,line5,line6,line7;


    public String[]  x={"Man","Woman"};
    public DataBaseConnection connection;
    public AnchorPane achnopane;

    // Switch To Sign In page of Employer
    @FXML
    public void SwitchToSignIn(ActionEvent event) throws IOException {
        achnopane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Employer/Authentification/LogIn.fxml"));
        Parent root = loader.load();
        Login controller = loader.getController();
        controller.connection = connection;
        controller.achnopane = achnopane;
        achnopane.getChildren().add(root);
        new FadeIn(root).play();
    }
    // add to data base

    // Switch To Sign 
    @FXML
    public void login_return(ActionEvent event) throws Exception {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        if (first_name.getText().isEmpty()) {
            line1.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("First name is required.\n");
        }
        if (!mail.getText().contains("@gmail.com") || mail.getText().isEmpty()) {
            line3.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Invalid email address.\n");
        }
        if (last_name.getText().isEmpty()) {
            line2.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Last name is required.\n");
        }
        if (phone.getText().isEmpty() || phone.getText().length() > 16 || phone.getText().length() < 10) {
            line6.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Invalid phone number.\n");
        }
        if (age.getText().isEmpty() || Integer.parseInt(age.getText()) < 18 || Integer.parseInt(age.getText()) > 45) {
            line7.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Age must be between 18 and 45.\n");
        }
        if (address.getText().isEmpty()) {
            line5.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Address is required.\n");
        }
        if (natio.getText().isEmpty()) {
            line4.setStyle("-fx-stroke:red;");
            isValid = false;
            errorMessage.append("Nationality is required.\n");
        }
        if (sex.getValue() == null || sex.getValue().equals("Sex")) {
            sended.setVisible(true);
            sended.setText("You should identify your gender");
            sended.setStyle("-fx-text-fill: red; -fx-background-color: #292929;");
            isValid = false;
        }

        if (isValid) {
            send_mail(mail.getText(), first_name.getText() + " " + last_name.getText(), phone.getText());
            String gender = sex.getValue().equals("Man") ? "h" : "f";
            int rs = connection.insertdb(first_name.getText(), last_name.getText(), address.getText(), mail.getText(), gender, Integer.parseInt(age.getText()), phone.getText(), natio.getText());
            if (rs > 0) {
                System.out.println("hola");
            } else {
                sended.setVisible(true);
                sended.setText("Error in loading information");
                sended.setStyle("-fx-text-fill: red; -fx-background-color: #292929;");
            }
        } else {
            sended.setVisible(true);
            sended.setText(errorMessage.toString());
            sended.setStyle("-fx-text-fill: red; -fx-background-color: #292929;");
        }
    }


    // function for send request to add account 

    void send_mail(String mail,String name,String phone_number){
            String to = "yassine.boujrada@gmail.com";
            String from = "centre.declaration@gmail.com";
            String host = "smtp.gmail.com";
            final String username ="centre.declaration@gmail.com";
            final String password = "bouchaib2021";
    
            //setup mail server
    
            Properties props = System.getProperties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
            try{
                //create mail
                MimeMessage m = new MimeMessage(session);
                m.setFrom(new InternetAddress(from));
                m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
                m.setSubject("add acount");
                m.setText("there is a new request to add an account of "+name+"\nemail :"+mail+"\nphone number :"+phone_number);
    
                //send mail
                Transport.send(m);
                sended.setVisible(true);
                sended.setText("Message sent :)");
                sended.setStyle("-fx-text-fill:  #009400; -fx-background-color: #292929;");
                System.out.println("Message sent!");
    
            }   catch (MessagingException e){
               e.getMessage();
               sended.setText("Message not sent :(");
               sended.setStyle("-fx-text-fill:  red; -fx-background-color: #292929;");
            }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        sex.getItems().addAll(x);
    }

}
