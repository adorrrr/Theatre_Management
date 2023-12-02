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
 * @author User
 */
public class ProductionManagerAddTransportationController implements Initializable {

   @FXML
    private TextField DriverNameTextField;
    @FXML
    private TextField DriverContactTextField;
    @FXML
    private ComboBox<String> vehicleTypeComboBox;
    @FXML
    private TextField NumberPlateTextField;
    @FXML
    private ComboBox<String> FromComboBox;
    @FXML
    private DatePicker DateDatepicker;
    @FXML
    private ComboBox<String> ToComboBox;
    @FXML
    private TableView<ProductionManagerTransportList> TableTableView;
    @FXML
    private TableColumn<ProductionManagerTransportList, String> NameColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, Integer> ContactColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, String> TypeColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, String> NumberColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, String> FromColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, String> ToColumn;
    @FXML
    private TableColumn<ProductionManagerTransportList, LocalDate> DateColumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         vehicleTypeComboBox.getItems().addAll("Ac Mini Bus","Non Ac Bus","Hiace");
        FromComboBox.getItems().addAll("Kuril","Jamuna","Notun Bazar");
        ToComboBox.getItems().addAll("Rampura","Banasree","Demra","Farmgate");
    }    

    @FXML
    private void ExitButtonOnMouseClick(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ProductionManagerdashboard.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void ShowButtoonMouseClick(ActionEvent event) {
       ProductionManagerTransportList i = new ProductionManagerTransportList(
            DriverNameTextField.getText(),
            Integer.parseInt(DriverContactTextField.getText()),
            vehicleTypeComboBox.getValue(),
            NumberPlateTextField.getText(),    
            FromComboBox.getValue(),
            ToComboBox.getValue(),
            DateDatepicker.getValue()
    );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Transport List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerAddTransportationController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerAddTransportationController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
     ObservableList<ProductionManagerTransportList> transportLIst = FXCollections.observableArrayList();
   
     NameColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, String>("name"));
        ContactColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, Integer>("contact"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, String>("Type"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, String>("plate"));
        FromColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, String>("From"));
        ToColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, String>("To"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerTransportList, LocalDate>("date"));   
      
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Transport List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ProductionManagerTransportList p;
            try {
                while (true) {
                    p = (ProductionManagerTransportList) ois.readObject();
                    transportLIst.add(p);
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
        TableTableView.setItems(transportLIst);
    DriverNameTextField.clear();
    DriverContactTextField.clear();
    vehicleTypeComboBox.setValue(null);
    NumberPlateTextField.clear();
    FromComboBox.setValue(null);
    ToComboBox.setValue(null);
    DateDatepicker.setValue(null);
          
    }
    
}
