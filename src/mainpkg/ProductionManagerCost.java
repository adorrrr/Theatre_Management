/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class ProductionManagerCost implements Serializable{
    String Department;
    int cost;

    public ProductionManagerCost(String Department, int cost) {
        this.Department = Department;
        this.cost = cost;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductionManagerCost{" + "Department=" + Department + ", cost=" + cost + '}';
    }
    
    
    
}
