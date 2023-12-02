/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author rttit
 */
public class VenueScheduleTable implements Serializable{
    
    private String showName;
    private String venue;
    private LocalDate date;
    private String time;

    public VenueScheduleTable(String showName, String venue, LocalDate date, String time) {
        this.showName = showName;
        this.venue = venue;
        this.date = date;
        this.time = time;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VenueScheduleTable{" + "showName=" + showName + ", venue=" + venue + ", date=" + date + ", time=" + time + '}';
    }
    
    
}
