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
public class ProductionManagerCostController implements Initializable {

    @FXML
    private TableView<ProductionManagerCost> TableTableView;
    @FXML
    private TableColumn<ProductionManagerCost, String> DepartmentColumn;
    @FXML
    private TableColumn<ProductionManagerCost, Integer> CostColumn;
    @FXML
    private TextField TotalCostTextField;
    @FXML
    private TextField DepartmentTextfield;
    @FXML
    private TextField CostTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void SaveButtonOnMouseClick(ActionEvent event) {
        ProductionManagerCost i = new ProductionManagerCost(
        DepartmentTextfield.getText(),
         Integer.parseInt(CostTextField.getText())       
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Cost List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerCostController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerCostController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
     ObservableList<ProductionManagerCost> CostList = FXCollections.observableArrayList();
   
     DepartmentColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerCost, String>("Department"));
     CostColumn.setCellValueFactory(new PropertyValueFactory<ProductionManagerCost, Integer>("cost"));
    
        
      
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Cost List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ProductionManagerCost p;
            try {
                while (true) {
                    p = (ProductionManagerCost) ois.readObject();
                    CostList.add(p);
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
        TableTableView.setItems(CostList);
    DepartmentTextfield.clear();
    CostTextField.clear();
  
        
    }

    @FXML
    private void TotalButtonOnMouseClick(ActionEvent event) {
        
    }
    
}
