package com.rabbitmq.rabbitmq.test.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msgString = "fanoutSender : Hello i am hzb";
        System.out.println(msgString);
        this.amqpTemplate.convertAndSend("fanoutExchange","abcd.ee",msgString);
    }
}
