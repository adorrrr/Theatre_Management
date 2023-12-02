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
public class CostumeDesiginerController implements Initializable {

    @FXML
    private TextField NameTextField;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> ShiftComboBox;
    @FXML
    private DatePicker DateDatePicker;
    @FXML
    private TextField SalaryTextField;

    @FXML
    private TableView<CostumeDesignerTable> TableView;
    @FXML
    private TableColumn<CostumeDesignerTable, String> NameColumn;
    @FXML
    private TableColumn<CostumeDesignerTable, Integer> MobileNumberColumn;
    @FXML
    private TableColumn<CostumeDesignerTable, String> EmailColumn;
    @FXML
    private TableColumn<CostumeDesignerTable, String> ShiftColumn;
    @FXML
    private TableColumn<CostumeDesignerTable, LocalDate> DateColumn;
    @FXML
    private TableColumn<CostumeDesignerTable, Float> SalaryColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShiftComboBox.getItems().addAll("Day","Evening","Night");

    }    

    @FXML
    private void AddButtonOnMouseClick(ActionEvent event) {
                CostumeDesignerTable i = new CostumeDesignerTable(
            NameTextField.getText(),
            Integer.parseInt(mobileNumberTextField.getText()),
            emailTextField.getText(),
            ShiftComboBox.getValue(),    
            DateDatePicker.getValue(),
            Float.parseFloat(SalaryTextField.getText()
 
    ));
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Costume Desiginer List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            

        } catch (IOException ex) {
            Logger.getLogger(CostumeDesiginerController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(CostumeDesiginerController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
     ObservableList<CostumeDesignerTable> CostumeDesiginerList = FXCollections.observableArrayList();
   
     NameColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, String>("name"));
     MobileNumberColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, Integer>("mobile"));
     EmailColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, String>("email"));
     ShiftColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, String>("shift"));
     DateColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, LocalDate>("date"));           
     SalaryColumn.setCellValueFactory(new PropertyValueFactory<CostumeDesignerTable, Float>("salary"));
      
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Costume Desiginer List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CostumeDesignerTable p;
            try {
                while (true) {
                    p = (CostumeDesignerTable) ois.readObject();
                    CostumeDesiginerList.add(p);
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
        TableView.setItems(CostumeDesiginerList);
    NameTextField.clear();
    mobileNumberTextField.clear();
    emailTextField.clear();
    ShiftComboBox.setValue(null);
    DateDatePicker.setValue(null);
    SalaryTextField.clear(); 
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
    private void DeleteButtonOnMouseClick(ActionEvent event) {
        ObservableList<CostumeDesignerTable> a, b;
        b = TableView.getItems();
        a = TableView.getSelectionModel().getSelectedItems();
        a.forEach(b::remove);
    }
    
}
