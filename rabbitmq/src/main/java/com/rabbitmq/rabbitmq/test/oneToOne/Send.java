package com.rabbitmq.rabbitmq.test.oneToOne;

import com.rabbitmq.client.MessageProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;



    public void send(){
        String context = "hello" + new Date();
        System.out.println("Sender:" + context);
        this.amqpTemplate.convertAndSend("hello",context,
                MessageProperties.PERSISTENT_TEXT_PLAIN);
    }
}
