package com.credits.producer.controller;

import com.credits.producer.dto.request.Order;
import com.credits.producer.dto.response.StatusResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/credits")
public class Producer {

    private final RuntimeService runtimeService;

    public Producer(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping
    public StatusResponse addCredit(@RequestBody Order request){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("ProducerCreditProcess")
                .setVariable("request", request)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusResponse.class);
    }


}
