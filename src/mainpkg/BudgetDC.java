package mainpkg;

import java.io.Serializable;

public class BudgetDC implements Serializable{
    protected String department;
    protected int budget;

    public BudgetDC(String department, int budget) {
        this.department = department;
        this.budget = budget;
    }

    public String getDepartment() {
        return department;
    }

    public int getBudget() {
        return budget;
    }
    
}
