package com.rabbitmq.rabbitmq.test.oneToMany;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "消息：测试但生产者，多消费者";
        for (int i = 0; i < 5; i++) {
            System.out.println("我是服务提供者： "+context+i);
            this.amqpTemplate.convertAndSend("oneToMany",context+i);
        }
    }

}
