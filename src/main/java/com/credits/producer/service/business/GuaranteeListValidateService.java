package com.credits.producer.service.business;

import com.credits.producer.dto.request.CustomerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuaranteeListValidateService {

    private CustomerValidateService customerValidateService;

    public GuaranteeListValidateService(CustomerValidateService customerValidateService) {
        this.customerValidateService = customerValidateService;
    }

    public boolean checkGuaranteeList(List<CustomerDetails> guaranteeList) {

        boolean checkGuarantee = true;
        if(guaranteeList.isEmpty()){
            checkGuarantee = false;
        }
        for(CustomerDetails customerDetails: guaranteeList){
         checkGuarantee = customerValidateService.checkCustomerDetails(customerDetails);
        }
        return checkGuarantee;
    }
}
