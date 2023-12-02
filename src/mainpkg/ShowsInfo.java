package mainpkg;


import java.io.Serializable;
import java.time.LocalDate;


public class ShowsInfo implements Serializable{
     protected String text;
     protected String showName;
     protected int seat;
     protected String vanue;
     protected LocalDate date;
     protected float price;
     protected String time;
    
    public ShowsInfo (String text, String showName, int seat, String vanue, LocalDate date, float price, String time )
    {
        this.text = text;
        this.showName = showName;
        this.seat = seat;
        this.vanue= vanue;
        this.date = date;
        this.price = price;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public String getShowName() {
        return showName;
    }

    public int getSeat() {
        return seat;
    }

    public String getVanue() {
        return vanue;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }
    
    
    
}
