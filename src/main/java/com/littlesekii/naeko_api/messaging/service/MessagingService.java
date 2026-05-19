package com.littlesekii.naeko_api.messaging.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    @Autowired
    RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(String message) {
        template.convertAndSend(queue.getName(), message);
    }
    
}
