package com.component;

import org.springframework.stereotype.Component;

import com.pojo.CommentMsg;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
public class MessageProducer {
   // private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNewCommentNotification(CommentMsg comment) {
        rabbitTemplate.convertAndSend("Comment Notification Queue", comment);
        log.info("{} sends message successfully.", getClass().getSimpleName());
    }
}