package com.tanjiaming99.event.comment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/17 14:44
 * @description
 */

@Slf4j
public class NewCommentEvent  extends ApplicationEvent {



    public NewCommentEvent(Object source) {
        super(source);
        log.info("新增评论，触发邮件发送服务。");
    }
}
