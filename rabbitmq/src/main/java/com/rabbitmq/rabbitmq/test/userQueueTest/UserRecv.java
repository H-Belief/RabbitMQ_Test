package com.rabbitmq.rabbitmq.test.userQueueTest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "userQueue")
public class UserRecv {
    @RabbitHandler
    public void recv(User user){
        System.out.println("user send: "+ user.getName() + ",  "+user.getAge()+","+user.getBirthday());
    }
}
