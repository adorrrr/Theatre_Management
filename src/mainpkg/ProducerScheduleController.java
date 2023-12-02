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
public class ProducerScheduleController implements Initializable {

    @FXML
    private TextField btnMeetingName;
    @FXML
    private Label lblMeeting;
    @FXML
    private Label lblDate;
    @FXML
    private DatePicker pickDate;
    @FXML
    private TextArea textOutputArea;
    @FXML
    private Button showOutput;
    @FXML
    private Button btnBackDashboard;
    @FXML
    private Button deleteMeeting;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void btnShowMeetingDetails(ActionEvent event) {
        String meetingName = btnMeetingName.getText();
        String date = pickDate.getValue().toString();
        textOutputArea.appendText("Meeting with: " + meetingName + "\n");
        textOutputArea.appendText("Scheduled Date: " + date + "\n\n");
    }


    @FXML
    private void backToProducerDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void btndeleteMeeting(ActionEvent event) {
        String selectedText = textOutputArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            int start = textOutputArea.getSelection().getStart();
            int end = textOutputArea.getSelection().getEnd();
            textOutputArea.deleteText(start, end);
       }
    }
    
}
