package com.credits.producer.service.business;

import com.credits.producer.dto.request.CustomerDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidateService {
    public boolean checkCustomerDetails(CustomerDetails customerDetails) {

        boolean checkCustomer = true;

        checkCustomerIsNull(customerDetails,checkCustomer);
        if(customerDetails.getIncome().doubleValue() < 300){
            checkCustomer = false;
        }
        if(customerDetails.getWorkExperience() < 6 ){
            checkCustomer = false;
        }

        return checkCustomer;
    }

    public void checkCustomerIsNull(CustomerDetails customer,boolean check){
        if(customer.getCurrentAddress() == null || customer.getDocFin() == null || customer.getFirstName() == null
                || customer.getLastName() == null || customer.getIncome() == null || customer.getWorkExperience() == null
        || customer.getWorkPlace() == null || customer.getPhoneList().isEmpty()){
            check = false;
        }

    }
}
