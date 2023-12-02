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
public class TechnicalTeamController implements Initializable {

       @FXML private ComboBox<String> TechnicalTeamComboBox;
    @FXML private TextField MemberTextField;
    @FXML private ComboBox<String> ShiftComboBox;
    @FXML private DatePicker dateDatePicker;
    @FXML private TextField TeamLeaderContactTextField;
    @FXML private TextField SalaryTextField;
    
    @FXML private TableView<TechnicalTeam> TableView;
    @FXML private TableColumn<TechnicalTeam, String> TechnicalTeamColumn;
    @FXML private TableColumn<TechnicalTeam, Integer> MembersColumn;
    @FXML private TableColumn<TechnicalTeam, String> ShiftColumn;
    @FXML private TableColumn<TechnicalTeam, LocalDate> DateColumn;
    @FXML private TableColumn<TechnicalTeam, Integer> TeamLeaderContactColumn;
    @FXML private TableColumn<TechnicalTeam, Float> SalaryColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TechnicalTeamComboBox.getItems().addAll("Sound","Light","Power");
        ShiftComboBox.getItems().addAll("Day","Evening","Night");
        
    }    

    @FXML
    private void AddButtonOnMouseClick(ActionEvent event) {
      TechnicalTeam i = new TechnicalTeam(
    
            TechnicalTeamComboBox.getValue(),
            Integer.parseInt(MemberTextField.getText()),
            ShiftComboBox.getValue(),
            dateDatePicker.getValue(),
            Integer.parseInt(TeamLeaderContactTextField.getText()),
            Float.parseFloat(SalaryTextField.getText()
            ));
     
         FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Technical Team List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            

        } catch (IOException ex) {
            Logger.getLogger(TechnicalTeamController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(TechnicalTeamController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Clear all input fields after adding a team
        TechnicalTeamComboBox.setValue(null);
        MemberTextField.clear();
        ShiftComboBox.setValue(null);
        dateDatePicker.setValue(null);
        TeamLeaderContactTextField.clear();
        SalaryTextField.clear();  
    }

    @FXML
    private void CancelButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ProductionManagerdashboard.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void ShowButtonOnMouseClick(ActionEvent event) {
         ObservableList<TechnicalTeam> teamList = FXCollections.observableArrayList();
     
    TechnicalTeamColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, String>("Team"));
    MembersColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, Integer>("Members"));
    ShiftColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, String>("Shift"));    
    DateColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, LocalDate>("Date"));
    TeamLeaderContactColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, Integer>("Contact"));   
    SalaryColumn.setCellValueFactory(new PropertyValueFactory<TechnicalTeam, Float>("salary"));       
    
     File f = null;
     FileInputStream fis = null;
     ObjectInputStream ois = null;

        try {
         f = new File("Technical Team List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TechnicalTeam p;
            try {
                while (true) {
                    p = (TechnicalTeam) ois.readObject();
                    teamList.add(p);
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
        TableView.setItems(teamList);
    }

    @FXML
    private void DeleteButtonOnMouseClick(ActionEvent event) {
         ObservableList<TechnicalTeam> a, b;
        b = TableView.getItems();
        a = TableView.getSelectionModel().getSelectedItems();
        a.forEach(b::remove);
    }
    
}
