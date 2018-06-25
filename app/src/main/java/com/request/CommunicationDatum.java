
package com.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunicationDatum {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("destination")
    @Expose
    private String destination;

    public CommunicationDatum(String type, String category, String destination, Addon addon) {
        this.type = type;
        this.category = category;
        this.destination = destination;
        this.addon = addon;
    }

    @SerializedName("addon")
    @Expose
    private Addon addon;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Addon getAddon() {
        return addon;
    }

    public void setAddon(Addon addon) {
        this.addon = addon;
    }

}
