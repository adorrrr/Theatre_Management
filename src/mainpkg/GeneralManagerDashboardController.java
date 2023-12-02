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
public class GeneralManagerDashboardController implements Initializable {

    @FXML
    private Button btnFinance;
    @FXML
    private Button btnSchedule;
    @FXML
    private Button btnShift;
    @FXML
    private Button btnMonthReport;
    @FXML
    private Button btnChat;
    @FXML
    private Button btnTerm;
    @FXML
    private Button btnSignOut;
    @FXML
    private Label lblRongodoot;
    @FXML
    private Label lblDashboard;
    @FXML
    private Button gmContactList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goFinance(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerFinance.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void goSchedule(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerSchedule.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void GoShiftCheck(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerEmployeeShiftCheck.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void goReport(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerMonthlyReport.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void chatBox(ActionEvent event) {
    }

    @FXML
    private void goTerm(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerTermAndConditions.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void goSignOut(ActionEvent event) {
    }

    @FXML
    private void btnContactList(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerContactList.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
