package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue commentNotificationQueue() {
        return new Queue("Comment Notification Queue");
    }
}