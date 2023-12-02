
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;


public class CostumeDesignerTable implements Serializable{
    private String name;
    private int mobile;
    private String email;
    private String shift;
    public LocalDate date;
    private float salary;

    public CostumeDesignerTable(String name, int mobile, String email, String shift, LocalDate date, float salary) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.shift = shift;
        this.date = date;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CostumeDesignerTable{" + "name=" + name + ", mobile=" + mobile + ", email=" + email + ", shift=" + shift + ", date=" + date + ", salary=" + salary + '}';
    }
    
    
}
