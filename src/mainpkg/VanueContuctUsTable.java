/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author rttit
 */
public class VanueContuctUsTable implements Serializable{
    private String venueName;
    private String address;
    private int number;
    private String mail;

    public VanueContuctUsTable(String venueName, String address, int number, String mail) {
        this.venueName = venueName;
        this.address = address;
        this.number = number;
        this.mail = mail;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "VanueContuctUsTable{" + "venueName=" + venueName + ", address=" + address + ", number=" + number + ", mail=" + mail + '}';
    }
    
    
}
