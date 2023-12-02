
package mainpkg;

/**
 *
 * @author Nisa
 */
public class Expense {
    private String department;
    private int expense;

    public Expense(String department, int expense) {
        this.department = department;
        this.expense = expense;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Expense{" + "department=" + department + ", expense=" + expense + '}';
    }
    
    
}
