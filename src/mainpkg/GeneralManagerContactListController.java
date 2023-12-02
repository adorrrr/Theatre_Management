package mainpkg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class GeneralManagerContactListController implements Initializable {

    @FXML
    private TableView<ContactList> contactListTable;
    @FXML
    private TableColumn<ContactList, String> columnDepartment;
    @FXML
    private TableColumn<ContactList, String> columnName;
    @FXML
    private TableColumn<ContactList, Integer> ColumnPhone;
    @FXML
    private TableColumn<ContactList, String> columnEmail;
    @FXML
    private TextField deptName;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPhone;
    @FXML
    private TextField textEmail;
    @FXML
    private Button addList;
    @FXML
    private Button deleteRow;
    @FXML
    private Button saveBin;
    @FXML
    private Button backDashboard;

    /**
     * Initializes the controller class.
     */
    private final ObservableList<ContactList> contactList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnDepartment.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        ColumnPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        columnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        contactListTable.setItems(contactList);
    }    

    @FXML
    private void btnAddList(ActionEvent event) {
        String name = textName.getText();
        String department = deptName.getText();
        int phone = Integer.parseInt(textPhone.getText());
        String email = textEmail.getText();
        ContactList contact = new ContactList(department, name, phone, email);
        contactList.add(contact);
        textName.clear();
        deptName.clear();
        textPhone.clear();
        textEmail.clear();
    }

    @FXML
    private void btnDeleteRow(ActionEvent event) {
        ContactList selectedContact = contactListTable.getSelectionModel().getSelectedItem();
    if (selectedContact != null) {
        contactList.remove(selectedContact);
    } else {
        System.out.println("Please select a row to delete.");
    }
}

    @FXML
    private void btnSaveBin(ActionEvent event) {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactList.bin"))) {
        oos.writeObject(new ArrayList<>(contactList));
        System.out.println("Data saved to contactList.bin");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @FXML
    private void btnBackToDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
