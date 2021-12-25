package Controllers.Employer.Authentification;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
<<<<<<< HEAD

=======
import Main.DataBaseConnection;
import animatefx.animation.FadeIn;
>>>>>>> 36a78b60564e8d7c4a220a01828774ad75fb53ae
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javax.mail.*;
import javax.mail.internet.*;
import javafx.scene.layout.AnchorPane;

import Main.DataBaseConnection;

import java.util.*;
import java.sql.*;

public class SignUp implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label sended;
    
    @FXML
    private TextField mail, phone ,address,age,first_name,last_name;
    @FXML
    private ComboBox<String> sex;


    public String[]  x={"Man","Woman"};
    public DataBaseConnection con = new DataBaseConnection();
    public DataBaseConnection connection;
    public AnchorPane achnopane;

    // Switch To Sign In page of Employer

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
        String gender;
        if(first_name.getText().length()!=0 && mail.getText().contains("@gmail.com") && !(last_name.getText().isEmpty()) && !(phone.getText().isEmpty()) && age.getText().length()==2 && Integer.parseInt(age.getText())>18 && Integer.parseInt(age.getText())<45 && phone.getText().length()<16){
            System.out.println("let start"+sex.getValue());
            send_mail(mail.getText(),first_name.getText()+" "+last_name.getText(),phone.getText());
            if (sex.getValue()=="Man") {
                gender="h";
            }
            else{
                gender="f";
            }
            int rs=con.insertdb(first_name.getText()+" "+last_name.getText(), address.getText(), mail.getText(),gender, Integer.parseInt(age.getText()), phone.getText());
            if (rs>0){
                System.out.println("hola");    
            }else{
                sended.setVisible(true);
                sended.setStyle("Erreur in load information");
                sended.setStyle("-fx-text-fill: red; -fx-background-color: #292929;");
            }
        }
        else{
            sended.setVisible(true);
            sended.setStyle("Erreur informations");
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
