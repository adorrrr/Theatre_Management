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
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class VenueScheduleController implements Initializable {

    @FXML
    private TextField showNameTextField;
    @FXML
    private TextField VenueTextFiled;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> timeComboBox;
    @FXML
    private TableView<VenueScheduleTable> showScheduleTable;
    @FXML
    private TableColumn<VenueScheduleTable, String> showNameColumn;
    @FXML
    private TableColumn<VenueScheduleTable, String> venueColumn;
    @FXML
    private TableColumn<VenueScheduleTable, LocalDate> dateColumn;
    @FXML
    private TableColumn<VenueScheduleTable, String> timeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeComboBox.getItems().addAll(
                "2 to 4pm",
                "4 to 6pm",
                "6 to 8pm",
                "8 to 10pm");
        
/*
            showNameColumn.setCellValueFactory(new PropertyValueFactory<>("showName"));
            venueColumn.setCellValueFactory(new PropertyValueFactory<>("venue"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        
        */        
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
    private void addButtononClick(ActionEvent event) {
        
 /*
        String shownamecombo = showNameTextField.getText();
        String venuecombo = VenueTextFiled.getText();
        LocalDate datecom = dateDatePicker.getValue();
        String timecombo = timeComboBox.getValue();
        
        showScheduleTable.getItems().add(
                new VenueScheduleTable(shownamecombo, venuecombo, datecom , timecombo)
        );

        */
        
        VenueScheduleTable i = new VenueScheduleTable(
                showNameTextField.getText(), 
                VenueTextFiled.getText(),
                dateDatePicker.getValue(),
                timeComboBox.getValue());
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Venue Schedule.bin");
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
            Logger.getLogger(VenueScheduleController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VenueScheduleController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        ObservableList<VenueScheduleTable> venueschedules = FXCollections.observableArrayList();
        
            showNameColumn.setCellValueFactory(new PropertyValueFactory<>("showName"));
            venueColumn.setCellValueFactory(new PropertyValueFactory<>("venue"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Venue Schedule.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VenueScheduleTable p;
            try {
                while (true) {
                    p = (VenueScheduleTable) ois.readObject();
                    venueschedules.add(p);
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
        showScheduleTable.setItems(venueschedules);
    }

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        
                showNameTextField.clear();
                VenueTextFiled.clear();
                dateDatePicker.setValue(null);
                timeComboBox.setValue(null);
    }

    @FXML
    private void deleteButtonOnclick(ActionEvent event) {
        ObservableList<VenueScheduleTable> selectedBudget, allschedule;
        allschedule = showScheduleTable.getItems();
        selectedBudget = showScheduleTable.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allschedule::remove);
    }
    
    
}