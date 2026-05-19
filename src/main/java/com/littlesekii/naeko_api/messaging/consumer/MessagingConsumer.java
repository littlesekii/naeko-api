package com.littlesekii.naeko_api.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "msg")
public class MessagingConsumer {
    
    @RabbitHandler
    public void listen(String message) {
        System.out.println(message);
    }
}
