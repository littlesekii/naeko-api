package com.littlesekii.naeko_api.messaging.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    
    @Bean
    public Queue msg() {
        return QueueBuilder.durable("msg").quorum().build();
    }
}
