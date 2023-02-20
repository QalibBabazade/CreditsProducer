package com.credits.producer.deligates;

import com.credits.producer.dto.request.Order;
import com.credits.producer.service.business.GuaranteeListValidateService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkGuaranteeList")
public class CheckGuaranteeList implements JavaDelegate {

    private final GuaranteeListValidateService guaranteeListValidateService;

    public CheckGuaranteeList(GuaranteeListValidateService guaranteeListValidateService) {
        this.guaranteeListValidateService = guaranteeListValidateService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Order order = (Order) execution.getVariable("request");
        boolean checkGuarantee =  guaranteeListValidateService.checkGuaranteeList(order.getGuaranteeList());
        execution.setVariable("checkGuarantee",checkGuarantee);
    }
}
