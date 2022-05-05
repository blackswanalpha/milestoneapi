package com.milestone.api.venue;



public class VenueBean {
    public VenueBean() {
        super();
    }

    public VenueBean(int venueId) {
        this.venueId = venueId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getVenueContact() {
        return venueContact;
    }

    public void setVenueContact(int venueContact) {
        this.venueContact = venueContact;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public int getVenueCompanyId() {
        return venueCompanyId;
    }

    public void setVenueCompanyId(int venueCompanyId) {
        this.venueCompanyId = venueCompanyId;
    }

    public int getVenueCost() {
        return venueCost;
    }

    public void setVenueCost(int venueCost) {
        this.venueCost = venueCost;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueImg() {
        return venueImg;
    }

    public void setVenueImg(String venueImg) {
        this.venueImg = venueImg;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    private int venueId, venueContact,venueCapacity,venueCompanyId,venueCost;
private String venueName,venueImg,venueLocation;

    public VenueBean(int venueId, int venueContact, int venueCapacity, int venueCompanyId, int venueCost, String venueName, String venueImg, String venueLocation) {
        this.venueId = venueId;
        this.venueContact = venueContact;
        this.venueCapacity = venueCapacity;
        this.venueCompanyId = venueCompanyId;
        this.venueCost = venueCost;
        this.venueName = venueName;
        this.venueImg = venueImg;
        this.venueLocation = venueLocation;
    }
}
