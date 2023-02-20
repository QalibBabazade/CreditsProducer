package com.credits.producer.deligates;

import com.credits.producer.dto.request.Order;
import com.credits.producer.service.business.CreditDetailsValidateService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCreditDetails")
public class CheckCreditDetails implements JavaDelegate {

    private final CreditDetailsValidateService creditDetailsValidateService;

    public CheckCreditDetails(CreditDetailsValidateService creditDetailsValidateService) {
        this.creditDetailsValidateService = creditDetailsValidateService;
    }

    public void execute(DelegateExecution execution) throws Exception {

        Order order = (Order) execution.getVariable("request");
        boolean checkCredit = creditDetailsValidateService.checkCreditDetails(order.getCreditDetails());
        execution.setVariable("checkCredit",checkCredit);

    }
}
