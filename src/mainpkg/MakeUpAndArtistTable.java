/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class MakeUpAndArtistTable implements Serializable{
    String Type;
    String Name;
    int Number;
    String Shift;
    String Email;
    LocalDate Date;
    Float salary;

    public MakeUpAndArtistTable(String Type, String Name, int Number, String Shift, String Email, LocalDate Date, Float salary) {
        this.Type = Type;
        this.Name = Name;
        this.Number = Number;
        this.Shift = Shift;
        this.Email = Email;
        this.Date = Date;
        this.salary = salary;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MakeUpAndArtistTable{" + "Type=" + Type + ", Name=" + Name + ", Number=" + Number + ", Shift=" + Shift + ", Email=" + Email + ", Date=" + Date + ", salary=" + salary + '}';
    }
    
    
    
}
