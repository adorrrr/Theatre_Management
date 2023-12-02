package mainpkg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class GeneralManagerEmployeeShiftCheckController implements Initializable {

    @FXML
    private Label lblEmployeeShift;
    @FXML
    private TableView<EmployeeShift> gmEmployeeShifttable;
    @FXML
    private TableColumn<EmployeeShift, String> callName;
    @FXML
    private TableColumn<EmployeeShift, String> calldepartment;
    @FXML
    private TableColumn<EmployeeShift, String> calldate;
    @FXML
    private TableColumn<EmployeeShift, String> callShiftStart;
    @FXML
    private TableColumn<EmployeeShift, String> callShiftEnd;
    @FXML
    private TableColumn<EmployeeShift, String> callPresence;
    @FXML
    private Label lbldate;
    @FXML
    private DatePicker datePiclker;
    @FXML
    private TextField TextPresence;
    @FXML
    private TextArea AreaShowOutput;
    @FXML
    private Button addTableInfo;
    @FXML
    private Button deletetableinfo;
    @FXML
    private Button loadData;
    @FXML
    private Button backDashboard;

    /**
     * Initializes the controller class.
     */
    private ObservableList<EmployeeShift> employeeShifts = FXCollections.observableArrayList();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        callName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        calldepartment.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartment()));
        calldate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        callShiftStart.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftStart()));
        callShiftEnd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftEnd()));
        callPresence.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPresence()));
        gmEmployeeShifttable.setItems(employeeShifts);
     
    }    

    @FXML
    private void addInfo(ActionEvent event) {
        LocalDate date = datePiclker.getValue();
        String[] fixedNames = {"Ayesha Siddika", "Ahsanul Adar", "Tamzed Hossain", "Rownok Islam", "Adlul Islam", "Tahmina Akter"};
        String[] fixedDepartments = {"Manager", "Director", "Production", "Marketing", "Production", "Catering"};
        String[] fixedShiftStarts = {"09:00 AM", "09:00 AM", "09:00 AM", "09:00 AM", "09:00 AM", "09:00 AM"};
        String[] fixedShiftEnds = {"05:00 PM", "05:00 PM", "05:00 PM", "05:00 PM", "05:00 PM", "05:00 PM"};
        int currentIndex = employeeShifts.size();

        if (currentIndex < fixedNames.length) {
        String name = fixedNames[currentIndex];
        String department = fixedDepartments[currentIndex];
        String shiftStart = fixedShiftStarts[currentIndex];
        String shiftEnd = fixedShiftEnds[currentIndex];
        String presence = TextPresence.getText();


        

        EmployeeShift employeeShift = new EmployeeShift(name, department, date, shiftStart, shiftEnd, presence);
        employeeShifts.add(employeeShift);
        //gmEmployeeShifttable.getItems().add(employeeShift);
         gmEmployeeShifttable.setItems(employeeShifts);
        AreaShowOutput.appendText(employeeShift.toString() + "\n");
        datePiclker.setValue(null);
        TextPresence.clear();
    }
}

    @FXML
    private void DeleteInfo(ActionEvent event) {
        EmployeeShift selectedShift = gmEmployeeShifttable.getSelectionModel().getSelectedItem();

        if (selectedShift != null) {
            employeeShifts.remove(selectedShift); // Remove from the observable list
            gmEmployeeShifttable.setItems(employeeShifts); // Refresh the table view
            AreaShowOutput.clear(); // Clear the text area and repopulate
            employeeShifts.forEach(shift -> AreaShowOutput.appendText(shift.toString() + "\n"));
        }    
    }

    @FXML
    private void DataLoad(ActionEvent event) {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employeeShifts.bin"))) {
           oos.writeObject(new ArrayList<>(employeeShifts));
           System.out.println("Data saved to file successfully.");
    }   catch (IOException e) {
           e.printStackTrace();
    }
}

    @FXML
    private void backOnDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

}
