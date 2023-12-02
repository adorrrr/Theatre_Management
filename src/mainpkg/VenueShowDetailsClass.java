
package mainpkg;

import java.io.Serializable;



public class VenueShowDetailsClass implements Serializable{
    private String showName;
    private String showDetails;

    public VenueShowDetailsClass(String showName) {
        this.showName = showName;
        this.showDetails = showDetails;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    @Override
    public String toString() {
        return "VenueShowDetailsClass{" + "showName=" + showName + ", showDetails=" + showDetails + '}';
    }

}