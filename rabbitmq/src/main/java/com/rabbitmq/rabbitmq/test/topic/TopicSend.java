package com.rabbitmq.rabbitmq.test.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg1 = "我是topic.message ========";
        System.out.println("sender1: "+msg1);
        this.amqpTemplate.convertAndSend("exchange","topic.message",msg1);


        String msg2 = "我是topic.messages msg######";
        System.out.println("sender2: "+msg2);
        this.amqpTemplate.convertAndSend("exchange","topic.messages",msg2);
    }
}
