package mainpkg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class TermAndConditionsController implements Initializable {

    @FXML
    private Label lblTerm;
    @FXML
    private Button btnShow;
    @FXML
    private TextArea txtOutputTerm;
    @FXML
    private Button btnReturn;
    @FXML
    private Button saveFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void showTerms(ActionEvent event) {
        String termsAndConditions =
                "RONGODOOT\n" +
                "Company Terms and Conditions\n" +
                "Bashundhara Residential Area, Block C, House- 283, Dhaka\n" +
                "+8801316314370\n" +
                "Last updated: November 22, 2024\n\n" +
                "Introduction:\n" +
                "This terms and conditions (agreement) discusses the guidelines,\n"+ "rules, and regulations of Rongodoot company.\n"+ "This will be followed by the company members.\n\n" +
                "Terms:\n" +
                "1. Customer contact is legally bound by the company.\n" +
                "2. Goals will be maintained by all members.";
               
        txtOutputTerm.setText(termsAndConditions);
    }

    @FXML
    private void returnDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void saveBinFile(ActionEvent event) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("termsAndConditions.bin"))) {
             String termsAndConditions = txtOutputTerm.getText();
            oos.writeObject(termsAndConditions);
            System.out.println("Data saved to binary file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
