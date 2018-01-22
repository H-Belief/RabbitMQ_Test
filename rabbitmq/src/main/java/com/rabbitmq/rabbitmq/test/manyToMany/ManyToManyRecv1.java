package com.rabbitmq.rabbitmq.test.manyToMany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "manyToMany")
public class ManyToManyRecv1 {
    @RabbitHandler
    public void recv(String hello){
        System.out.println("我是消费者1"+hello);
    }
}
