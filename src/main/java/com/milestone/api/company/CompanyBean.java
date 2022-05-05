package com.milestone.api.company;

public class CompanyBean {
    private int companyId;
    private int companyContact;

    public int getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(int companyUserId) {
        this.companyUserId = companyUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private int companyUserId;
    private String companyName;



    private String companyDesc;
    private String companyEmail;
    private String companyLocation;
    private String companyAddress;
    private String userName;
    

    public CompanyBean(int companyId, int companyContact, int companyUserId, String companyName, String companyDesc, String companyEmail, String location, String companyAddress, String userName) {
        this.companyId = companyId;
        this.companyContact = companyContact;
        this.companyUserId = companyUserId;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
        this.companyEmail = companyEmail;
        this.companyLocation = location;
        this.companyAddress = companyAddress;
        this.userName = userName;
    }

    public CompanyBean(int companyId) {
        this.companyId = companyId;
    }

    public CompanyBean() {
        super();
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(int companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
