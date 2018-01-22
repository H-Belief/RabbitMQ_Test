package com.rabbitmq.rabbitmq.test.manyToMany;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManyToManySender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="消息:测试多生产者，多消费者";
        System.out.println("我是服务生产者2："+context);
        this.amqpTemplate.convertAndSend("manyToMany",context);
    }
}
