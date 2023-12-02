
package mainpkg;

/**
 *
 * @author Nisa
 */
public class Profit  {
    private String department;
    private int profit;

    public Profit(String department, int profit) {
        this.department = department;
        this.profit = profit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Profit{" + "department=" + department + ", profit=" + profit + '}';
    }
    
}
