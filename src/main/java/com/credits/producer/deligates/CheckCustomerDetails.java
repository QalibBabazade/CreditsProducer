package com.credits.producer.deligates;

import com.credits.producer.dto.request.Order;
import com.credits.producer.service.business.CustomerValidateService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCustomerDetails")
public class CheckCustomerDetails implements JavaDelegate {

    private final CustomerValidateService customerValidateService;

    public CheckCustomerDetails(CustomerValidateService customerValidateService) {
        this.customerValidateService = customerValidateService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
      Order order = (Order) execution.getVariable("request");
      boolean checkCustomer = customerValidateService.checkCustomerDetails(order.getCustomerDetails());
      execution.setVariable("checkCustomer",checkCustomer);
    }
}
