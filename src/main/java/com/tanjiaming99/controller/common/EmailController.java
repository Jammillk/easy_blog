package com.tanjiaming99.controller.common;

import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.entity.Email;
import com.tanjiaming99.service.IEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:06
 **/
@RestController
@Api(value = "邮件服务模块", tags = "邮件服务模块")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/email")
    @ApiOperation(value = "发送邮件")
    public AjaxRes<?> send(@RequestBody Email email) {
        return emailService.sendEmail(email) ? AjaxRes.success("发送成功") : AjaxRes.fail("发送失败");
    }

}
