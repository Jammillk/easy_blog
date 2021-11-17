package com.tanjiaming99.listener.comment;

import com.tanjiaming99.event.comment.NewCommentEvent;
import com.tanjiaming99.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/17 15:15
 * @description
 */
@Component
@Slf4j
public class CommentEventListener {
    @Autowired
    private IEmailService emailService;
    @EventListener
    public void handleCommentNewEvent(NewCommentEvent newEvent) {
        System.out.println("---"+newEvent);
        System.out.println(newEvent.getSource());
    }
}
