package com.rabbitmq.rabbitmq.test.oneToMany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "oneToMany")
public class Recv2 {
    @RabbitHandler
    public void process(String hello){
        System.out.println("我是消费者2："+hello);
    }
}
