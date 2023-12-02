/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class VanueTicketControlController implements Initializable {

    @FXML
    private TableView<VanueTicketControlTable> TicketControlTable;
    @FXML
    private TableColumn<VanueTicketControlTable, String> showNamecolumn;
    @FXML
    private TableColumn<VanueTicketControlTable, LocalDate> showDateColumn;
    @FXML
    private TableColumn<VanueTicketControlTable, String> membershipColumn;
    @FXML
    private TableColumn<VanueTicketControlTable, Integer> numberTicketSellColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void LoadButtonOnClick(ActionEvent event) {
        
        ObservableList<VanueTicketControlTable> TicketControls = FXCollections.observableArrayList();
        
        showNamecolumn.setCellValueFactory(new PropertyValueFactory<>("showName"));
        showDateColumn.setCellValueFactory(new PropertyValueFactory<>("showDate"));
        membershipColumn.setCellValueFactory(new PropertyValueFactory<>("membership"));
        numberTicketSellColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfTicket"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File f= null;
        try {
            f = new File("Purchase Ticket.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VanueTicketControlTable p;
            try {
                while (true) {
                    p = (VanueTicketControlTable) ois.readObject();
                    TicketControls.add(p);
                    System.out.println(p.toString());
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
        TicketControlTable.setItems(TicketControls);
        
    }
    
}
