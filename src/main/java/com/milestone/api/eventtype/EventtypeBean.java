package com.milestone.api.eventtype;

public class EventtypeBean {
    public EventtypeBean() {
        super();
    }

    public int getEventtypeId() {
        return eventtypeId;
    }

    public void setEventtypeId(int eventtypeId) {
        this.eventtypeId = eventtypeId;
    }

    public int getEventtypeVenueId() {
        return eventtypeVenueId;
    }

    public void setEventtypeVenueId(int eventtypeVenueId) {
        this.eventtypeVenueId = eventtypeVenueId;
    }

    public int getEventtypeCompanyId() {
        return eventtypeCompanyId;
    }

    public void setEventtypeCompanyId(int eventtypeCompanyId) {
        this.eventtypeCompanyId = eventtypeCompanyId;
    }

    public String getEventtypeName() {
        return eventtypeName;
    }

    public void setEventtypeName(String eventtypeName) {
        this.eventtypeName = eventtypeName;
    }

    public String getEventtypeDesc() {
        return eventtypeDesc;
    }

    public void setEventtypeDesc(String eventtypeDesc) {
        this.eventtypeDesc = eventtypeDesc;
    }

    public String getEventtypeImg() {
        return eventtypeImg;
    }

    public void setEventtypeImg(String eventtypeImg) {
        this.eventtypeImg = eventtypeImg;
    }

    public float getEventtypeCost() {
        return eventtypeCost;
    }

    public void setEventtypeCost(float eventtypeCost) {
        this.eventtypeCost = eventtypeCost;
    }

    private  int eventtypeId,eventtypeVenueId,eventtypeCompanyId;
    private  String eventtypeName,eventtypeDesc, eventtypeImg;
    private float eventtypeCost;

    public EventtypeBean(int eventtypeId, int eventtypeVenueId, int eventtypeCompanyId, String eventtypeName, String eventtypeDesc, String eventtypeImg, float eventtypeCost) {
        this.eventtypeId = eventtypeId;
        this.eventtypeVenueId = eventtypeVenueId;
        this.eventtypeCompanyId = eventtypeCompanyId;
        this.eventtypeName = eventtypeName;
        this.eventtypeDesc = eventtypeDesc;
        this.eventtypeImg = eventtypeImg;
        this.eventtypeCost = eventtypeCost;
    }

    public EventtypeBean(int eventtypeCompanyId) {
        this.eventtypeCompanyId = eventtypeCompanyId;
    }
}
