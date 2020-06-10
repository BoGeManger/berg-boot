package com.berg.config;

import com.berg.constant.RabbitMqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean(name = RabbitMqConstants.Exchange.MASTER_EXCHANGE)
    DirectExchange masterExchange() {
        return new DirectExchange(RabbitMqConstants.Exchange.MASTER_EXCHANGE,true,false);
    }

    @Bean(name = RabbitMqConstants.Queue.TEST_QUEUE)
    public Queue testQueue() {
        Queue queue = new Queue(RabbitMqConstants.Queue.TEST_QUEUE,true,false,false);
        return queue;
    }

    @Bean
    Binding bindTestQueue(Queue testQueue, DirectExchange masterExchange) {
        return BindingBuilder.bind(testQueue).to(masterExchange).with(RabbitMqConstants.Queue.TEST_QUEUE);
    }
}
