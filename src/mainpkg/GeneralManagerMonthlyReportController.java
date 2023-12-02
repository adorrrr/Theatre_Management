
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class GeneralManagerMonthlyReportController implements Initializable {

    @FXML
    private LineChart<?, ?> ticketSaleChart;
    @FXML
    private LineChart<?, ?> monthIncomeChart;
    @FXML
    private Button btnTicketSale;
    @FXML
    private Button btnMonthIncome;
    @FXML
    private Label lblMonthReport;
    @FXML
    private Button btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ticketSalech(ActionEvent event) {
    }

    @FXML
    private void MonthIncomeCh(ActionEvent event) {
    }

    @FXML
    private void returnBtnDashboard(ActionEvent event) {
    }
    
}
