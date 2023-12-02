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
public class MarketingSocialMediaCampaignsTable implements Serializable{
    
    private String name;
    private String campaigns;

    public MarketingSocialMediaCampaignsTable(String name, String campaigns) {
        this.name = name;
        this.campaigns = campaigns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(String campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public String toString() {
        return "MarketingSocialMediaCampaignsTable{" + "name=" + name + ", campaigns=" + campaigns + '}';
    }
     
}
