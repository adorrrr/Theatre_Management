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
public class MarketingSocialMediaCampaignsController implements Initializable {

    @FXML
    private TextField volunteerNameTextField;
    @FXML
    private TextField campaignsLocationTextField;
    @FXML
    private TableView<MarketingSocialMediaCampaignsTable> campaignsShowTable;
    @FXML
    private TableColumn<MarketingSocialMediaCampaignsTable, String> volunteerNameColumn;
    @FXML
    private TableColumn<MarketingSocialMediaCampaignsTable, String> campaignsLocationColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
/*        volunteerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        campaignsLocationColumn.setCellValueFactory(new PropertyValueFactory<>("campaigns"));
*/        
        
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
    private void showListButtonOnClick(ActionEvent event) {
        
 /*       String volunN = volunteerNameTextField.getText();
        String camp = campaignsLocationTextField.getText();
        
        campaignsShowTable.getItems().add(
                new MarketingSocialMediaCampaignsTable(volunN, camp));
 */     
 
    MarketingSocialMediaCampaignsTable i = new MarketingSocialMediaCampaignsTable( volunteerNameTextField.getText(), campaignsLocationTextField.getText());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("socialMedia Campaigns.bin");
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
            Logger.getLogger(MarketingSocialMediaCampaignsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(MarketingSocialMediaCampaignsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ObservableList<MarketingSocialMediaCampaignsTable> socialMedia = FXCollections.observableArrayList();
        
        volunteerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        campaignsLocationColumn.setCellValueFactory(new PropertyValueFactory<>("campaigns"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("socialMedia Campaigns.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MarketingSocialMediaCampaignsTable p;
            try {
                while (true) {
                    p = (MarketingSocialMediaCampaignsTable) ois.readObject();
                    socialMedia.add(p);
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
        campaignsShowTable.setItems(socialMedia);
 
    }
    
}
