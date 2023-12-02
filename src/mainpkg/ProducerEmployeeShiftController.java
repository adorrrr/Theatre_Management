package mainpkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class ProducerEmployeeShiftController implements Initializable {

    @FXML
    private TableView<EmployeeShift> shiftTable;
    @FXML
    private TableColumn<EmployeeShift, String> columnName;
    @FXML
    private TableColumn<EmployeeShift, String> columndept;
    @FXML
    private TableColumn<EmployeeShift, LocalDate> columnDate;
    @FXML
    private TableColumn<EmployeeShift, String> columnShiftStart;
    @FXML
    private TableColumn<EmployeeShift, String> ColumnShiftEnd;
    @FXML
    private TableColumn<EmployeeShift, String> columnPresence;
    @FXML
    private Button loadData;

    /**
     * Initializes the controller class.
     */
    private ObservableList<EmployeeShift> employeeShifts = FXCollections.observableArrayList();
    @FXML
    private Button backDashboard;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        columndept.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartment()));
        //columnDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        columnShiftStart.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftStart()));
        ColumnShiftEnd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftEnd()));
        columnPresence.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPresence()));
        shiftTable.setItems(employeeShifts);
    }    
    @FXML
    private void btnLoadData(ActionEvent event) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employeeShifts.bin"))) {
        ArrayList<EmployeeShift> loadedEmployeeShifts = (ArrayList<EmployeeShift>) ois.readObject();
        employeeShifts.clear();
        employeeShifts.addAll(loadedEmployeeShifts);
        System.out.println("Data loaded from file successfully.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}


    @FXML
    private void backProducerDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
