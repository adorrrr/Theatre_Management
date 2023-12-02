/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author rttit
 */
public class VanueTicketControlTable {
    private String showName;
    private LocalDate showDate;
    private String membership;
    private int numberOfTicket;

    public VanueTicketControlTable(String showName, LocalDate showDate, String membership, int numberOfTicket) {
        this.showName = showName;
        this.showDate = showDate;
        this.membership = membership;
        this.numberOfTicket = numberOfTicket;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    @Override
    public String toString() {
        return "VanueTicketControlTable{" + "showName=" + showName + ", showDate=" + showDate + ", membership=" + membership + ", numberOfTicket=" + numberOfTicket + '}';
    }
    
}
