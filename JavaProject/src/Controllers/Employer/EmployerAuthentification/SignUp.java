package Controllers.Employer.EmployerAuthentification;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SignUp {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField confirme_pass, pass;
    @FXML
    private TextField mail, user;

    // Switch To Sign In page of Employer
    @FXML
    public void SwitchToSignIn(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass()
                .getResource("../../../Resources/VIEW/Employer/Authentification/EmployerLogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // add to data base
    @FXML
    public void login_return(ActionEvent event) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                "hotel");
        Statement st = con.createStatement();
        if (mail.getText().contains("@gmail.com") && pass.getText().length() > 2
                && pass.getText().equals(confirme_pass.getText())) {
            int x = 0;
            ResultSet rs = st.executeQuery("select count(id_compte) as nbr from compte_employee");
            while (rs.next()) {
                x = rs.getInt("nbr");
                System.out.println(x);
            }
            int result = st.executeUpdate("insert into compte_employee(id_compte,email,password) values(" + (x + 1)
                    + ",'" + mail.getText().toLowerCase() + "','" + pass.getText() + "')");
            if (result > 0) {
                System.out.println("oh boy");
                SwitchToSignIn(event);
            } else {
                System.out.println("finawa ghadi");
            }
        }
    }
}
