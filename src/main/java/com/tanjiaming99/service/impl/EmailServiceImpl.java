package com.tanjiaming99.service.impl;

import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.tanjiaming99.model.entity.Email;
import com.tanjiaming99.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:26
 **/
@Service
@Slf4j
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 模版引擎
     */
    private static final TemplateEngine templateEngine = TemplateUtil.createEngine();

    private static final String noticeTemplatePath = "mail_template/mail_notice.ftl";


//    @Value("${mail.fromMail.addr}")
//    private String from;

    @Override
    public Boolean sendEmail(Email email) {
        Boolean result = Boolean.TRUE;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
//            helper.setReplyTo(email.getTo());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(templateForText(email));
            mailSender.send(message);
        } catch (MessagingException e) {
            log.info(String.valueOf(e));
            result = Boolean.FALSE;
        }
        return result;
    }

    /**
     * 绑定回复邮件模版
     * @param email 邮件内容
     * @return
     */
    private String templateForText(Email email) {
        Map<String, String> bindingMap = new HashMap<>(16);
        bindingMap.put("context", email.getContext());
        bindingMap.put("from", email.getFrom());
        bindingMap.put("to", email.getTo());
        bindingMap.put("subject", email.getSubject());
        return templateEngine.getTemplate(noticeTemplatePath).render(bindingMap);
    }
}
