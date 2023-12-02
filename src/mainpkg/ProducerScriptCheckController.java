package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class ProducerScriptCheckController implements Initializable {

    @FXML
    private Button loadScript;
    @FXML
    private Button lblscriptOk;
    @FXML
    private Button recheckScript;
    @FXML
    private TextArea showScript;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLoadScript(ActionEvent event) {
    }

    @FXML
    private void btnOk(ActionEvent event) {
    }

    @FXML
    private void btnRecheck(ActionEvent event) {
    }
    
}
