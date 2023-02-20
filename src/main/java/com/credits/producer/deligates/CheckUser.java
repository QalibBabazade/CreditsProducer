package com.credits.producer.deligates;

import com.credits.producer.dto.request.Order;
import com.credits.producer.service.business.CheckUserService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkUser")
public class CheckUser implements JavaDelegate {

    private final CheckUserService checkUserService;

    public CheckUser(CheckUserService checkUserService) {
        this.checkUserService = checkUserService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
       Order order = (Order) execution.getVariable("request");
       boolean checkUser = checkUserService.checkUser(order.getUser().getId());
       execution.setVariable("checkUser",checkUser);

    }
}
