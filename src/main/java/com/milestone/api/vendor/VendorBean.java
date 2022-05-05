package com.milestone.api.vendor;

public class VendorBean {
    private  int vendorId,vendorTypeId,vendorCompanyId;
    private String vendorName,vendorImg,vendorDesc;
    private float vendorCost;

    public VendorBean(int vendorId, int vendorCost, int vendorTypeId, int vendorCompanyId, String vendorName, String vendorImg, String vendorDesc) {
        this.vendorId = vendorId;
        this.vendorCost = vendorCost;
        this.vendorTypeId = vendorTypeId;
        this.vendorCompanyId = vendorCompanyId;
        this.vendorName = vendorName;
        this.vendorImg = vendorImg;
        this.vendorDesc = vendorDesc;
    }

    public VendorBean(int vendorId) {
        this.vendorId = vendorId;
    }

    public VendorBean(){

    }


    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public float getVendorCost() {
        return vendorCost;
    }

    public void setVendorCost(float vendorCost) {
        this.vendorCost = vendorCost;
    }

    public int getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(int vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public int getVendorCompanyId() {
        return vendorCompanyId;
    }

    public void setVendorCompanyId(int vendorCompanyId) {
        this.vendorCompanyId = vendorCompanyId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorImg() {
        return vendorImg;
    }

    public void setVendorImg(String vendorImg) {
        this.vendorImg = vendorImg;
    }

    public String getVendorDesc() {
        return vendorDesc;
    }

    public void setVendorDesc(String vendorDesc) {
        this.vendorDesc = vendorDesc;
    }
}
