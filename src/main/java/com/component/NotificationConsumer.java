package com.component;

import com.pojo.CommentMsg;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationConsumer {
	@Component
	public class NotificationWorkerConsumer1 {
	    //private static final Logger LOGGER = LoggerFactory.getLogger(NotificationWorkerConsumer1.class);

	    @RabbitListener(queues = "Comment Notification Queue")
	    public void processMsg(@Payload CommentMsg comment) {
	        log.info("{} receives message successfully.", getClass().getSimpleName());
	    }
	}

	@Component
	public class NotificationWorkerConsumer2 {
	    //private static final Logger LOGGER = LoggerFactory.getLogger(NotificationWorkerConsumer2.class);

	    @RabbitListener(queues = "Comment Notification Queue")
	    public void processMsg(@Payload CommentMsg comment) {
	        log.info("{} receives message successfully.", getClass().getSimpleName());
	    }
	}
	    
}


