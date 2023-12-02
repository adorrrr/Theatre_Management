/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class MarketingVolunteersListController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TableView<MarketingVolunteersListTable> volunteerTable;
    @FXML
    private TableColumn<MarketingVolunteersListTable, Integer> idColumn;
    @FXML
    private TableColumn<MarketingVolunteersListTable, String> nameColumn;
    @FXML
    private TableColumn<MarketingVolunteersListTable, String> addressColumn;
    @FXML
    private TableColumn<MarketingVolunteersListTable, String> phoneColumn;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {      
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("MarketingManagerDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addListButtonOnClick(ActionEvent event) {
 /*     int id = Integer.parseInt(idTextField.getText());
        int phone = Integer.parseInt(phoneNumberTextField.getText());
        if (volunteerTable.getItems().stream().anyMatch(volunteer -> volunteer.getId() == id)) {
            showAlert(id);
            return;
        }
        volunteerTable.getItems().add(new MarketingVolunteersListTable(
                id,
                nameTextField.getText(),
                addressTextField.getText(),
                phone 
        ));
*/
 
        MarketingVolunteersListTable i = new MarketingVolunteersListTable( Integer.parseInt(idTextField.getText()), nameTextField.getText(), addressTextField.getText(),Integer.parseInt(phoneNumberTextField.getText()));
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Volunteers List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            System.out.println("write object sucessfull ");

        } catch (IOException ex) {
            Logger.getLogger(MarketingVolunteersListController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(MarketingVolunteersListController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ObservableList<MarketingVolunteersListTable> volunteerL = FXCollections.observableArrayList();
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Volunteers List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MarketingVolunteersListTable p;
            try {
                while (true) {
                    p = (MarketingVolunteersListTable) ois.readObject();
                    volunteerL.add(p);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
            
        }
        volunteerTable.setItems(volunteerL);
        
    }

   
    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        idTextField.clear();
        nameTextField.clear();
        phoneNumberTextField.clear();
        addressTextField.clear();
        
    }
    
/*    private void configureTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
    }
    private void showAlert(int id) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(idTextField.getScene().getWindow());
        alert.initModality(Modality.NONE);
        alert.setContentText("Volunteers with id " + id + " already exists!");
        alert.showAndWait();
    }
*/    

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        
        ObservableList<MarketingVolunteersListTable> selectedBudget, allVolunteer;
        allVolunteer = volunteerTable.getItems();
        selectedBudget = volunteerTable.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allVolunteer::remove);
    }

}