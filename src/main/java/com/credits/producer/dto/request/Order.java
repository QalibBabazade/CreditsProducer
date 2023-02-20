package com.credits.producer.dto.request;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private CreditDetails creditDetails;
    private CustomerDetails customerDetails;
    private List<CustomerDetails> guaranteeList;
    private User user;

    public Order() {
    }

    public Order(CreditDetails creditDetails, CustomerDetails customerDetails, List<CustomerDetails> guaranteeList, User user) {
        this.creditDetails = creditDetails;
        this.customerDetails = customerDetails;
        this.guaranteeList = guaranteeList;
        this.user = user;
    }

    public CreditDetails getCreditDetails() {
        return creditDetails;
    }

    public void setCreditDetails(CreditDetails creditDetails) {
        this.creditDetails = creditDetails;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<CustomerDetails> getGuaranteeList() {
        return guaranteeList;
    }

    public void setGuaranteeList(List<CustomerDetails> guaranteeList) {
        this.guaranteeList = guaranteeList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
