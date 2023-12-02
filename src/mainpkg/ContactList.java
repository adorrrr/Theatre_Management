package mainpkg;

import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContactList implements Serializable {
    private String department;
    private String name;
    private int phone;
    private String email;

    public ContactList(String department, String name, int phone, String email) {
        this.department = department;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SimpleStringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public SimpleStringProperty departmentProperty() {
        return new SimpleStringProperty(department);
    }

    public SimpleIntegerProperty phoneProperty() {
        return new SimpleIntegerProperty(phone);
    }

    public SimpleStringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }
}
