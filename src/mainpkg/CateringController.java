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
public class CateringController implements Initializable {

    @FXML   private TextField NumberOfPeopleTextField;
    @FXML   private DatePicker dateDatePicker;
    @FXML   private TextField MealItemTextField;
    @FXML   private ComboBox<String> MealOFTheDayComboBox;
    @FXML   private TextField CostTextField;  
    @FXML   private TableView<Catering> CateringOutputTableView; 
    @FXML   private TableColumn<Catering, LocalDate> DateTableColumn;
    @FXML   private TableColumn<Catering, String> MealOfTheDayTableColumn;
    @FXML   private TableColumn<Catering, Integer> CostTableColumn;
    @FXML   private TableColumn<Catering, Integer> NumberOfPeopleTableColumn; 
    @FXML   private TableColumn<Catering, String> MealItemTableColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         MealOFTheDayComboBox.getItems().addAll("Breakfast","Lunch","Snacks","Dinner");

    }    

    @FXML
    private void orderButtonOnMouseClick(ActionEvent event) {
         Catering i = new Catering(
     Integer.parseInt(NumberOfPeopleTextField.getText()),
            dateDatePicker.getValue(),
            MealItemTextField.getText(),
            MealOFTheDayComboBox.getValue(),
      Integer.parseInt(CostTextField.getText())     
    );
    
     FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Catering List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            

        } catch (IOException ex) {
            Logger.getLogger(CateringController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(CateringController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
     ObservableList<Catering> CateringList = FXCollections.observableArrayList();   
    
    NumberOfPeopleTableColumn.setCellValueFactory(new PropertyValueFactory<Catering, Integer>("NumberOfPeople")); 
     DateTableColumn.setCellValueFactory(new PropertyValueFactory<Catering, LocalDate>("Date")); 
    MealItemTableColumn.setCellValueFactory(new PropertyValueFactory<Catering, String>("MealItem")); 
    MealOfTheDayTableColumn.setCellValueFactory(new PropertyValueFactory<Catering, String>("MealOfTheDay")); 
    CostTableColumn.setCellValueFactory(new PropertyValueFactory<Catering, Integer>("Cost")); 
     
    FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Catering List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Catering p;
            try {
                while (true) {
                    p = (Catering) ois.readObject();
                    CateringList.add(p);
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
        CateringOutputTableView.setItems(CateringList);
     
    NumberOfPeopleTextField.clear();
    dateDatePicker.setValue(null);
    MealItemTextField.clear();
    MealOFTheDayComboBox.setValue(null);
    CostTextField.clear();
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
        ObservableList<Catering> selectedBudget, cateringtable;
        cateringtable = CateringOutputTableView.getItems();
        selectedBudget = CateringOutputTableView.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(cateringtable::remove);
    }
    
}
