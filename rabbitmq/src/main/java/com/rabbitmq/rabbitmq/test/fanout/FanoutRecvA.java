package com.rabbitmq.rabbitmq.test.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutRecvA {

    @RabbitHandler
    public void recv1(String msg){
        System.out.println("FanoutRecvA : "+msg);
    }
}
