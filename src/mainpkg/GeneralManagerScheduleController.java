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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class GeneralManagerScheduleController implements Initializable {

    @FXML
    private Label lblSchedule;
    @FXML
    private DatePicker gmScheDate;
    @FXML
    private Label lblDate;
    @FXML
    private Button btnDeleteDate;
    @FXML
    private TextArea dateOutput;
    @FXML
    private Button backDashboardSc;
    @FXML
    private Button btnDateFix;
    @FXML
    private Label lblMeeting;
    @FXML
    private TextField gmmettingWith;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnDashboardSc(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void gmScheDateFix(ActionEvent event) {
        String meetingWith = gmmettingWith.getText();
        String scheduleDate = gmScheDate.getValue().toString();
        dateOutput.appendText("Meeting with: " + meetingWith + "\n");
        dateOutput.appendText("Scheduled Date: " + scheduleDate + "\n\n");
    }

    @FXML
    private void gmScheDeleteDate(ActionEvent event) {
        String selectedText = dateOutput.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            int start = dateOutput.getSelection().getStart();
            int end = dateOutput.getSelection().getEnd();
            dateOutput.deleteText(start, end);
       }
    }
}

