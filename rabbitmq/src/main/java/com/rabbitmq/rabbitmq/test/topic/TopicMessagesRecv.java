package com.rabbitmq.rabbitmq.test.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesRecv {

    @RabbitHandler
    public void recv(String msg){
        System.out.println("队列二：topicMessagesReceiver:"+msg);
    }
}
