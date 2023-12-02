
package mainpkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nisa
 */
public class GeneralManagerFinanceController implements Initializable {

    @FXML
    private Label financeSection;
    @FXML
    private Label choosefinance;
    @FXML
    private TableColumn<Budget, String> callDepartment;
    @FXML
    private TableColumn<Budget, Integer> callBudget;
    @FXML
    private Label lblBudgetTable;
    @FXML
    private Button addBudget;
    @FXML
    private Button btnCalculateBudget;
    @FXML
    private Label lblTotalBudgetText;
    @FXML
    private TextField tblTotalBudget;
    @FXML
    private TableView<Expense> expenseTable;
    @FXML
    private TableColumn<Expense, String> expensedpt;
    @FXML
    private TableColumn<Expense, Integer> expenseCall;
    @FXML
    private Button btncalculateExpense;
    @FXML
    private Label lblExpense;
    @FXML
    private Label lblTotalExpensetex;
    @FXML
    private TextField textExpense;
    @FXML
    private Button tblBudgetDelete;
    @FXML
    private Button backDashboard;
    @FXML
    private Button loadExpense;
    @FXML
    private TextField deptName;
    @FXML
    private Label lblBudget;
    @FXML
    private TextField showBudget;
    @FXML
    private TableView<Budget> budgetTable;
    @FXML
    private TableColumn<Profit, String> callProfitDepartment;
    @FXML
    private TableColumn<Profit, Integer> callProfit;
    @FXML
    private Label lblProfit;
    @FXML
    private Button btnCalculateProfit;
    @FXML
    private Label lblTotalProfitText;
    @FXML
    private TextField textProfit;
    @FXML
    private Button loadProfit;
    @FXML
    private TableView<Profit> Profittable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //callDepartment.setCellValueFactory(new PropertyValueFactory<Budget, String>("department"));
        //callBudget.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("budget"));
        accessColumn();
        loadBudgetsFromFile();
    }    


    @FXML
    private void budgetAdd(ActionEvent event) {
        List<Budget> savedBudgets = loadBudgetsFromFile();

        Budget budget = new Budget(deptName.getText(), Integer.parseInt(showBudget.getText()));
        ObservableList<Budget> budgets = budgetTable.getItems();
        budgets.add(budget);
        budgetTable.setItems(budgets);

        savedBudgets.add(budget);  // Add the new budget to the existing list

        writeBudgetsToFile(savedBudgets);

        deptName.clear();
        showBudget.clear();
    }

    private void accessColumn() {
        callDepartment.setCellValueFactory(new PropertyValueFactory<Budget, String>("department"));
        callBudget.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("budget"));
    }

    private List<Budget> loadBudgetsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("budgets.bin"))) {
            List<Budget> savedBudgets = (List<Budget>) ois.readObject();
            budgetTable.getItems().addAll(savedBudgets);
            return savedBudgets;
        } catch (FileNotFoundException e) {
            System.out.println("File not found. This might be the first run.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void writeBudgetsToFile(List<Budget> budgets) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("budgets.bin"))) {
            oos.writeObject(budgets);
            System.out.println("Budgets written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calculateBudget(ActionEvent event) {
        ObservableList<Budget> budgets = budgetTable.getItems();
        int totalBudget = budgets.stream().mapToInt(Budget::getBudget).sum();
        tblTotalBudget.setText(Integer.toString(totalBudget));
    }

    @FXML
    private void budgetLoad(ActionEvent event) {
        List<Expense> savedExpenses = loadExpensesFromFile();
        expenseTable.getItems().setAll(savedExpenses);
    }
    
//Expense Table code
    @FXML
    private void expenseCalculate(ActionEvent event) {
        ObservableList<Expense> expenses = expenseTable.getItems();
        int totalExpense = expenses.stream().mapToInt(Expense::getExpense).sum();
        textExpense.setText(Integer.toString(totalExpense));
    }
    private List<Expense> loadExpensesFromFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expenses.bin"))) {
        return (List<Expense>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return Collections.emptyList(); 
}



    @FXML
    private void deleteBudget(ActionEvent event) {
        ObservableList<Budget> selectedBudget, allBudgets;
        allBudgets = budgetTable.getItems();
        selectedBudget = budgetTable.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allBudgets::remove);
    }

    


    @FXML
    private void backOnDashboard(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("GeneralManagerDashboard.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
//Profit Table code
    @FXML
    private void profitLoad(ActionEvent event) {
        List<Profit> savedProfit = loadProfitFromFile();
        Profittable.getItems().setAll(savedProfit);
    }
   

   
    //int totalBudget = calculateBudget(budgetTable.getItems());
    //int totalExpense = expenseCalculate(expenseTable.getItems());
    //ObservableList<Profit> profits = calculateProfits(budgetTable.getItems(), expenseTable.getItems());
    //Profittable.getItems().setAll(profits);
    //int totalProfit = calculateProfitTotal(profits);
    //textProfit.setText(Integer.toString(totalProfit));

    //}
     //private int calculateProfitTotal(ObservableList<Profit> calculateProfits(ObservableList<Budget> budgets, ObservableList<Expense> expenses)) { 
    //private (ObservableList<Profit> calculateProfits(ObservableList<Budget> budgets, ObservableList<Expense> expenses)) {
    //ObservableList<Profit> profits = FXCollections.observableArrayList();

   // for (int i = 0; i < budgets.size(); i++) {
        // Assuming Budget and Expense have getDepartment and getBudget/getExpense methods
        //String department = budgets.get(i).getDepartment();
        //int budget = budgets.get(i).getBudget();
        //int expense = (i < expenses.size()) ? expenses.get(i).getExpense() : 0;
        //int profit = budget - expense;

        //profits.add(new Profit(department, profit));
    //}

   // return profits;
//}
     
    //}
   

    


    private List<Profit> loadProfitFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profits.bin"))) {
            return (List<Profit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @FXML
    private void calculateProfit(ActionEvent event) {
    }
}

   

   


   
    
    
    

    

    



    
  
    
    
    
    

    

   
    

