/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class VenueSecurityTeamController implements Initializable {
    @FXML
    private TableColumn<VenueSecurityTeamTable, String> nameColumn;
    @FXML
    private TableColumn<VenueSecurityTeamTable, String> guardColumn;
    @FXML
    private TableColumn<VenueSecurityTeamTable, Integer> numberColumn;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> guardComboBox;
    @FXML
    private TextField numberTextField;
    @FXML
    private TableView<VenueSecurityTeamTable> venueSecurityTeamTable;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        guardComboBox.getItems().addAll(
                "Secutity Guard",
                "Venue Guard");
        
        
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        guardColumn.setCellValueFactory(new PropertyValueFactory<>("guard"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
    }    

    @FXML
    private void goBackButtonClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("VenueManagerDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addListButtonOnClick(ActionEvent event) {
        
        int number = Integer.parseInt(numberTextField.getText());
        
        venueSecurityTeamTable.getItems().add(new VenueSecurityTeamTable(
                nameTextField.getText(),
                guardComboBox.getValue(),
                number
        ));
        
    }

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        nameTextField.clear();
        guardComboBox.setValue(null);
        numberTextField.clear();
    }
    
}