
package mainpkg;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Nisa
 */
  //implements Serializable {


public class Budget {

    private SimpleStringProperty department;
    private SimpleIntegerProperty budget;

    public Budget(String department, int budget) {
        this.department = new SimpleStringProperty(department);
        this.budget = new SimpleIntegerProperty(budget);
    }

    public String getDepartment() {
        return department.get();
    }

    public SimpleStringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public int getBudget() {
        return budget.get();
    }

    public SimpleIntegerProperty budgetProperty() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget.set(budget);
    }
}
