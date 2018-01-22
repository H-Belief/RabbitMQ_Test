package com.rabbitmq.rabbitmq.test;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello",true);
    }

    @Bean
    public Queue oneToMany(){
        return new Queue("oneToMany");
    }

    @Bean
    public Queue manyToMany(){
        return new Queue("manyToMany");
    }

    @Bean
    public Queue userQueue(){
        return new Queue("userQueue");
    }


    @Bean
    public Queue queueMessage(){
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    /**
     *  queueMessage只匹配"topic.message"队列
     *  queueMessages匹配两个队列，
     *
     *（星号）：可以（只能）匹配一个单词
     #（井号）：可以匹配多个单词（或者零个）

     */

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    //将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }


    /*===============以下是验证Fanout Exchange的队列==========*/
    @Bean
    public Queue AMessage(){
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage(){
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage(){
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }


}
