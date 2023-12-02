/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author rttit
 */
public class VenueSecurityTeamTable {
    String name;
    private String guard;
    private int number;

    public VenueSecurityTeamTable(String name, String guard, int number) {
        this.name = name;
        this.guard = guard;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "VenueSecurityTeamTable{" + "name=" + name + ", guard=" + guard + ", number=" + number + '}';
    }
    
}
