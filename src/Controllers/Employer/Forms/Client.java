package Controllers.Employer.Forms;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import org.controlsfx.control.CheckComboBox;
import Main.DataBaseConnection;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Client implements Initializable {
    @FXML
    private Pane ChildPaneXS;
    @FXML
    private CheckComboBox<String> RoomFeatures;
    public DataBaseConnection connection;
    public Pane ParentPane;
    public Pane ResultPane;
    public LocalDate datentrer;
    public LocalDate datesortir;
    @FXML
    private TextField age, cin, first_name, gender, last_name, natio, etat;
    public int nbr_of_room;

    public void LoadResultForm(ActionEvent e) throws IOException {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(ResultPane.translateXProperty(), 100, Interpolator.EASE_OUT);
        KeyValue kv1 = new KeyValue(ChildPaneXS.translateXProperty(), 1024, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            ParentPane.getChildren().remove(ChildPaneXS);
        });
        timeline.play();
    }

    @FXML
    private void showAlertWithoutHeaderText() throws NumberFormatException, Exception {
        int rs, rs2;
        String sex = "";
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirme reservation");
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want complete ?");

        // alert.showAndWait();
        if (first_name.getText().isEmpty()) {
            first_name.setStyle("-fx-border-color:red; -fx-text-fill:#fff; -fx-background-color: #11111199;");
        }
        if (last_name.getText().isEmpty()) {
            last_name.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        }
        if (etat.getText().isEmpty()) {
            etat.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        }
        if (gender.getText().isEmpty() || !(gender.getText().toLowerCase().equals("man"))
                || !(gender.getText().toLowerCase().equals("woman"))) {
            gender.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        }
        if (age.getText().isEmpty() || Integer.parseInt(age.getText()) < 18 || Integer.parseInt(age.getText()) > 80) {
            age.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        }
        if (cin.getText().isEmpty() || cin.getText().length() > 3) {
            cin.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        }
        if (natio.getText().isEmpty()) {
            natio.setStyle("-fx-border-color:red; -fx-text-fill:red; -fx-background-color: #11111199;");
        } else {
            if (!(first_name.getText().isEmpty()) && !(last_name.getText().isEmpty()) && !(etat.getText().isEmpty())
                    && !(gender.getText().isEmpty()) && !(age.getText().isEmpty()) && !(natio.getText().isEmpty())) {
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);
                if (button == ButtonType.OK) {
                    if (gender.getText().toLowerCase().equals("man")) {
                        sex = "h";
                    } else if (gender.getText().toLowerCase().equals("woman")) {
                        sex = "f";
                    }
                    rs = connection.addClient(cin.getText(), first_name.getText(), last_name.getText(), natio.getText(),
                            sex, etat.getText(), age.getText());
                    // connection.reserverRoom(datentrer,datesortir,);
                    System.out.println("jdkjkckusdundus");
                    if (rs > 0) {
                        System.out.println("nice");
                        rs2 = connection.reserverRoom(datentrer, datesortir, connection.getCompte(), nbr_of_room,
                                cin.getText());
                        if (rs2 > 0) {
                            System.out.println("oh gggg");
                        } else {
                            Alert alert_erreur = new Alert(AlertType.WARNING);
                            alert_erreur.setTitle("Warning");
                            alert_erreur.setHeaderText(null);
                            alert_erreur.setContentText("There's a probleme in database");
                            alert_erreur.showAndWait();
                            connection.droped();
                        }
                    } else {
                        System.out.println("ghayad orifolki");
                    }

                } else {
                    System.out.println("canceled");
                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        final ObservableList<String> checkcomboboxelements = FXCollections.observableArrayList();
        String[] list = { "coffee Morning", "Wifi 5G", "Cushion", "Television", "Speaker", "End table", "Tea set",
                "Fireplace", "Floor lamp", "Tableet Blinds" };
        for (int i = 0; i < list.length; i++) {
            checkcomboboxelements.add(list[i]);
        }
        RoomFeatures.getItems().addAll(checkcomboboxelements);

    }
}
