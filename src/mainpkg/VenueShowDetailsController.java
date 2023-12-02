/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class VenueShowDetailsController implements Initializable {
    @FXML
    private TextField showDetailsTextfield;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private ComboBox<String> showNameComboBox;


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showNameComboBox.getItems().addAll("Nabanna", "Dharmashok","Gobheer Asukh", "Dakghar");
    }    


    
    @FXML
    private void showOutputButtonOnClick(ActionEvent event) {
        if(showNameComboBox.getValue().equals("Nabanna")){
            VenueShowDetailsClass i = new VenueShowDetailsClass(showDetailsTextfield.getText());
            
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Nabanna.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(VenueShowDetailsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VenueShowDetailsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        else if(showNameComboBox.getValue().equals("Dharmashok")){
            VenueShowDetailsClass i = new VenueShowDetailsClass(showDetailsTextfield.getText());
            
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Dharmashok.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(VenueShowDetailsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VenueShowDetailsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
           
        
        else if(showNameComboBox.getValue().equals("Gobheer Asukh")){
            VenueShowDetailsClass i = new VenueShowDetailsClass(showDetailsTextfield.getText());
            
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Gobheer Asukh.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(VenueShowDetailsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VenueShowDetailsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
           
        }
        else if(showNameComboBox.getValue().equals("Dakghar")){
            VenueShowDetailsClass i = new VenueShowDetailsClass(showDetailsTextfield.getText());
            
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Dakghar.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(VenueShowDetailsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(VenueShowDetailsController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
           
        }
        
      
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("VenueManagerDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
} 
