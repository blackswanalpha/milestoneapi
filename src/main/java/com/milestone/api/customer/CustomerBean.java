package com.milestone.api.customer;

public class CustomerBean {
    public CustomerBean() {
        super();

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    private int customerId,customerContact;
    private String customerName,customerEmail;

    public CustomerBean(int customerId, int customerContact, String customerName, String customerEmail) {
        this.customerId = customerId;
        this.customerContact = customerContact;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public CustomerBean(int customerContact) {
        this.customerContact = customerContact;
    }
}
