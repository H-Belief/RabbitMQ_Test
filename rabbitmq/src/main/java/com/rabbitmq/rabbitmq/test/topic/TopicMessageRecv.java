package com.rabbitmq.rabbitmq.test.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageRecv {

    @RabbitHandler
    public void recv(String msg){
        System.out.println("队列一：topicMessageReceiver:"+msg);
    }
}
