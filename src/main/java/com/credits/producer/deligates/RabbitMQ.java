package com.credits.producer.deligates;

import com.credits.producer.config.MessageConfig;
import com.credits.producer.dto.request.Order;
import com.credits.producer.dto.response.StatusResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component("rabbitMQ")
public class RabbitMQ implements JavaDelegate {

    private final RabbitTemplate template;

    public RabbitMQ(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Order order = (Order) execution.getVariable("request");
        template.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.ROUTING_KEY,order);
        StatusResponse statusResponse = StatusResponse.getSuccessMessage();
        execution.setVariable("status", statusResponse);
    }
}
