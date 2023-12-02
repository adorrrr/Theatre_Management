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
public class TechnicalTeam implements Serializable{

   private String Team;
   private int Members;
   private String Shift;
   private LocalDate Date;
   private int Contact;
   private Float salary;

    public TechnicalTeam(String Team, int Members, String Shift, LocalDate Date, int Contact, Float salary) {
        this.Team = Team;
        this.Members = Members;
        this.Shift = Shift;
        this.Date = Date;
        this.Contact = Contact;
        this.salary = salary;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public int getMembers() {
        return Members;
    }

    public void setMembers(int Members) {
        this.Members = Members;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TechnicalTeam{" + "Team=" + Team + ", Members=" + Members + ", Shift=" + Shift + ", Date=" + Date + ", Contact=" + Contact + ", salary=" + salary + '}';
    }

 
}
