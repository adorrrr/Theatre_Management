package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class ProducerDashboardController implements Initializable {

    @FXML
    private Label lblProducerDashboard;
    @FXML
    private Button btnSchedule;
    @FXML
    private Button btnScript;
    @FXML
    private Button btnBudget;
    @FXML
    private Button btnEmployeeShift;
    @FXML
    private Button btnContactList;
    @FXML
    private Button btnChat;
    @FXML
    private Button btnTerms;
    @FXML
    private Button btnSignOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void scheduleProducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerSchedule.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void scriptProducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerScriptCheck.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void budgetCheckproducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerBudgetcheck.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void employeeShiftProducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerEmployeeShift.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void contactListProducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerContactList.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void chatBox(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerChatBox.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void termProducer(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerTermsandConditions.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void signOutProducer(ActionEvent event) {
    }
    
}
