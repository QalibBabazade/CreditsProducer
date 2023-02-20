package com.credits.producer.deligates;

import com.credits.producer.dto.response.StatusResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("exceptionHandler")
public class ExceptionHandler implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Integer code =Integer.parseInt ((String) execution.getVariable("errorCode"));
        String message = (String) execution.getVariable("errorMessage");
        StatusResponse statusResponse = new StatusResponse(code,message);
        execution.setVariable("status",statusResponse);
    }
}
