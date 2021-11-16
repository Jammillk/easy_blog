package com.tanjiaming99.service.impl;

import com.tanjiaming99.model.entity.Email;
import com.tanjiaming99.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:26
 **/
@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

//    @Value("${mail.fromMail.addr}")
//    private String from;

    @Override
    public Boolean sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getContext());
        mailSender.send(message);
        return Boolean.TRUE;
    }
}
