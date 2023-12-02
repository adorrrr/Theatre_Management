package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class ProducerContactListController implements Initializable {

    @FXML
    private TableView<ContactList> tableContact;
    @FXML
    private TableColumn<ContactList, String> columnDept;
    @FXML
    private TableColumn<ContactList, String> columnName;
    @FXML
    private TableColumn<ContactList, Integer> columnPhone;
    @FXML
    private TableColumn<ContactList, String> columnEmail;
    @FXML
    private Button loadData;
    @FXML
    private Button backDashboard;

    /**
     * Initializes the controller class.
     */
    private final ObservableList<ContactList> producerContacts = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnDept.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        columnPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        columnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        tableContact.setItems(producerContacts);
    }    

    @FXML
    private void btnLoadData(ActionEvent event) {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactlist.bin"))) {
            ArrayList<ContactList> loadedData = (ArrayList<ContactList>) ois.readObject();
            producerContacts.clear();
            producerContacts.addAll(loadedData);
            System.out.println("Data loaded from contactList.bin");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
}

    @FXML
    private void btnBackDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ProducerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
