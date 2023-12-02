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
public class VanueContuctUsController implements Initializable {

    @FXML
    private TextField venuAddressTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField mailComboBox;
    @FXML
    private ComboBox<String> venueNameComboBox;
    @FXML
    private TableView<VanueContuctUsTable> contuctUsTable;
    @FXML
    private TableColumn<VanueContuctUsTable, String> VenueNameColumn;
    @FXML
    private TableColumn<VanueContuctUsTable, String> venueAddressColumn;
    @FXML
    private TableColumn<VanueContuctUsTable, Integer> numberColumn;
    @FXML
    private TableColumn<VanueContuctUsTable, String> mailColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        venueNameComboBox.getItems().addAll(
                "Dhaka",
                "Chittagong",
                "Kushtia",
                "Tangail");
    }
    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("VenueManagerDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        VanueContuctUsTable i = new VanueContuctUsTable(
                venueNameComboBox.getValue(), 
                venuAddressTextField.getText(), 
                Integer.parseInt(numberTextField.getText()), 
                mailComboBox.getText());
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Venue Contuct.bin");
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
            Logger.getLogger(VanueContuctUsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VanueContuctUsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(venueNameComboBox.getValue().equals("Dhaka")) {
        ObservableList<VanueContuctUsTable> venuenameList = FXCollections.observableArrayList();
        
        VenueNameColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("venueName"));
        venueAddressColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("address"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, Integer>("number"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("mail"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Dhaka.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VanueContuctUsTable p;
            try {
                while (true) {
                    p = (VanueContuctUsTable) ois.readObject();
                    venuenameList.add(p);
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
        contuctUsTable.setItems(venuenameList);
        }
        else if(venueNameComboBox.getValue().equals("Chittagong")) {
        ObservableList<VanueContuctUsTable> venuenameList = FXCollections.observableArrayList();
        
        VenueNameColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("venueName"));
        venueAddressColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("address"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, Integer>("number"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("mail"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Chittagong.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VanueContuctUsTable p;
            try {
                while (true) {
                    p = (VanueContuctUsTable) ois.readObject();
                    venuenameList.add(p);
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
        contuctUsTable.setItems(venuenameList);
        }
        
        else if(venueNameComboBox.getValue().equals("Kushtia")) {
        ObservableList<VanueContuctUsTable> venuenameList = FXCollections.observableArrayList();
        
        VenueNameColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("venueName"));
        venueAddressColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("address"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, Integer>("number"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("mail"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            f = new File("Kushtia.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VanueContuctUsTable p;
            try {
                while (true) {
                    p = (VanueContuctUsTable) ois.readObject();
                    venuenameList.add(p);
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
        contuctUsTable.setItems(venuenameList);
        }
         
        else if(venueNameComboBox.getValue().equals("Tangail")) {
        ObservableList<VanueContuctUsTable> venuenameList = FXCollections.observableArrayList();
        
        VenueNameColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("venueName"));
        venueAddressColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("address"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, Integer>("number"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<VanueContuctUsTable, String>("mail"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Tangail.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VanueContuctUsTable p;
            try {
                while (true) {
                    p = (VanueContuctUsTable) ois.readObject();
                    venuenameList.add(p);
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
        contuctUsTable.setItems(venuenameList);
        }
    }

    @FXML
    private void deleteButoonOnClick(ActionEvent event) {
        ObservableList<VanueContuctUsTable> selectedBudget, allcontuctUs;
        allcontuctUs = contuctUsTable.getItems();
        selectedBudget = contuctUsTable.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allcontuctUs::remove);
    }
}
