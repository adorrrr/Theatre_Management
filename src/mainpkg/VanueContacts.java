package mainpkg;

import java.io.Serializable;


public class VanueContacts implements Serializable{
     protected String Address;
     protected int Number;
     protected String Mail;

    public VanueContacts(String Address, int Number, String Mail) {
        this.Address = Address;
        this.Number = Number;
        this.Mail = Mail;
    }

    public String getAddress() {
        return Address;
    }

    public int getNumber() {
        return Number;
    }

    public String getMail() {
        return Mail;
    }
    
}
