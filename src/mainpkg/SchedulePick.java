
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;


public class SchedulePick implements Serializable {
    protected String department;
    protected int time;
    protected LocalDate Date;
    protected String schedule;

    public SchedulePick(String department, int time, LocalDate Date, String schedule) {
        this.department = department;
        this.time = time;
        this.Date = Date;
        this.schedule = schedule;
    }

    public String getDepartment() {
        return department;
    }

    public int getTime() {
        return time;
    }

    public LocalDate getDate() {
        return Date;
    }

    public String getSchedule() {
        return schedule;
    }
    
    
}
