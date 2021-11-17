package com.tanjiaming99.service.impl;

import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.tanjiaming99.model.entity.Email;
import com.tanjiaming99.service.IEmailService;
import com.tanjiaming99.utils.JsonUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:26
 **/
@Service
@Slf4j
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailParamService emailParamService;

    /**
     * 模版引擎
     */
    private static final TemplateEngine templateEngine = TemplateUtil.createEngine();

    private static final String noticeTemplatePath = "mail_template/mail_notice.ftl";

    private static final String replyTemplatePath = "mail_template/mail_reply.ftl";


    @Value("${mail.fromMail.addr}")
    private String blogAddressFrom;

    @Override
    public Boolean sendEmail(Email email) {
        Boolean result = Boolean.TRUE;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(templateForText(email), true);;
            mailSender.send(message);
        } catch (MessagingException e) {
            log.info(String.valueOf(e));
            result = Boolean.FALSE;
        }
        return result;
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * 绑定回复邮件模版
     *
     * @param email 邮件内容
     * @return
     */
    private String templateForText(Email email) {
        Map<String, String> bindingMap = Collections.emptyMap();
        Template template = null;
        try {
            Configuration configuration = freeMarkerConfigurer.getConfiguration();

            if (email.getMailType().equals(0)) {
                bindingMap = emailParamService.noticeParam(email);
                template = configuration.getTemplate(noticeTemplatePath);
                return FreeMarkerTemplateUtils.processTemplateIntoString(template, bindingMap);
            } else if (email.getMailType().equals(1)){
                bindingMap = emailParamService.replyParam(email);
                template = configuration.getTemplate(replyTemplatePath);
                return FreeMarkerTemplateUtils.processTemplateIntoString(template, bindingMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "error";
    }


}
