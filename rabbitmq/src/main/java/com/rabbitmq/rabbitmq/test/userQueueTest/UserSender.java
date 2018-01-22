package com.rabbitmq.rabbitmq.test.userQueueTest;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        User user = new User();
        user.setName("小笨笨");
        user.setAge("23");
        user.setBirthday("1021");
        System.out.println("user send: "+ user.getName() + ",  "+user.getAge()+","+user.getBirthday());
        this.amqpTemplate.convertAndSend("userQueue",user);
    }
}
