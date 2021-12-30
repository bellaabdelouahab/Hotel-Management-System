package Controllers.Admin.Functions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Controllers.Admin.Authentification.LoginController;
import Main.DataBaseConnection;
import animatefx.animation.FadeInRightBig;
import animatefx.animation.FadeOutLeft;

public class LeaderBord implements Initializable {

    @FXML
    private VBox AdminMenu;

    @FXML
    private Pane LeaderBoardData;

    private Pane CurrentTab;

    public Pane ParentPane;

    @FXML
    private AnchorPane ChiledStage;

    public DataBaseConnection connection = new DataBaseConnection();

    @FXML
    private Circle Notification;

    @FXML
    public void GoToModify(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/ModifyUser.fxml"));
        Parent root = loder.load();
        ModifyUserController controller = loder.getController();
        controller.LeaderBoardData = LeaderBoardData;
        controller.connection = connection;
        FadeOutLeft FideOut = new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(CurrentTab);
            CurrentTab = (Pane) root;
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }

    @FXML
    void SwitchToAddUser(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/AddUser.fxml"));
        Parent root = loder.load();
        AddUserController controller = loder.getController();
        controller.connection = connection;
        FadeOutLeft FideOut = new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(CurrentTab);
            CurrentTab = (Pane) root;
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }

    @FXML
    void SwitchToProfile(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/Profile.fxml"));
        Parent root = loder.load();
        ProfileController controller = loder.getController();
        controller.LeaderBoardData = LeaderBoardData;
        controller.connection = connection;
        FadeOutLeft FideOut = new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(CurrentTab);
            CurrentTab = (Pane) root;
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }

    public void ShowDashBoard() throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Functions/DashBoard.fxml"));
        Parent root = loder.load();
        DashBoardController controller = loder.getController();
        controller.connection = connection;
        controller.init();
        if (CurrentTab != null) {
            FadeOutLeft FideOut = new FadeOutLeft(CurrentTab);
            FideOut.play();
            FideOut.setOnFinished(e -> {
                LeaderBoardData.getChildren().remove(CurrentTab);
            });
        }
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
        });
    }

    public void SwitchToUser(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/User.fxml"));
        Parent root = loder.load();
        UserController controller = loder.getController();
        controller.connection = connection;
        controller.ParentPane = ParentPane;
        controller.init();
        FadeOutLeft FideOut = new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e -> {
            LeaderBoardData.getChildren().remove(CurrentTab);

        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e -> {
            CurrentTab = (Pane) root;
            controller.CurrentTab = CurrentTab;
        });
    }

    @FXML
    void LogOut(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(
                getClass().getResource("../../../Resources/VIEW/Admin/Authentification/Login.fxml"));
        Parent root = loder.load();
        LoginController controller = loder.getController();
        controller.ParentPane = ParentPane;
        controller.connection = connection;
        if (CurrentTab != null) {
            FadeOutLeft FideOut = new FadeOutLeft(ChiledStage);
            FideOut.play();
            FideOut.setOnFinished(e -> {
                ParentPane.getChildren().remove(ChiledStage);
                CurrentTab = (Pane) root;
            });
        }
        ParentPane.getChildren().add(root);
        new FadeInRightBig(root).play();
    }

    @FXML
    void ShowMenuBar(MouseEvent event) {
        AdminMenu.setVisible(true);
    }

    

    @FXML
    void HideMenuBar(MouseEvent event) {
        AdminMenu.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ResultSet test = connection.GetSignUpInformation();
        try {
            if(test.next()){
                Notification.setVisible(true);
            }
            else{
                Notification.setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AdminMenu.setVisible(false);

    }
    @FXML
    void SwitchToRoom(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Rooms.fxml"));
        Parent root = loder.load();
        RoomsController controller = loder.getController();
        controller.connection=connection;
        controller.ParentPane = ParentPane;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
            controller.CurrentTab=CurrentTab;
        });

    }

    @FXML
    void SwitchToClient(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Client.fxml"));
        Parent root = loder.load();
        ClientController controller = loder.getController();
        controller.connection=connection;
        controller.ParentPane = ParentPane;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
            controller.CurrentTab=CurrentTab;
        });
    }
    @FXML
    void SwitchToReservation(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/Reservation.fxml"));
        Parent root = loder.load();
        ReservationController controller = loder.getController();
        controller.connection=connection;
        controller.ParentPane = ParentPane;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
            controller.CurrentTab=CurrentTab;
        });
    }

    @FXML
    void SwitchToSignUp(MouseEvent event) throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("../../../Resources/VIEW/Admin/Functions/SignUp.fxml"));
        Parent root = loder.load();
        SignUpController controller = loder.getController();
        controller.connection=connection;
        controller.ParentPane = ParentPane;
        FadeOutLeft FideOut =new FadeOutLeft(CurrentTab);
        FideOut.play();
        FideOut.setOnFinished(e->{
            LeaderBoardData.getChildren().remove(CurrentTab);
            
        });
        LeaderBoardData.getChildren().add(root);
        FadeInRightBig animate = new FadeInRightBig(root);
        animate.play();
        animate.setOnFinished(e->{
            CurrentTab=(Pane) root;
            controller.CurrentTab=CurrentTab;
        });
        Notification.setVisible(false);
    }
}
