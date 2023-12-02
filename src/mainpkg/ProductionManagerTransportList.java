
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class ProductionManagerTransportList implements Serializable{
    String name;
    int contact;
    String Type;
    String plate;
    String From;
    String To;
    LocalDate date;

    public ProductionManagerTransportList(String name, int contact, String Type, String plate, String From, String To, LocalDate date) {
        this.name = name;
        this.contact = contact;
        this.Type = Type;
        this.plate = plate;
        this.From = From;
        this.To = To;
        this.date = date;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductionManagerTransportList{" + "name=" + name + ", contact=" + contact + ", Type=" + Type + ", plate=" + plate + ", From=" + From + ", To=" + To + ", date=" + date + '}';
    }

  
    
}
