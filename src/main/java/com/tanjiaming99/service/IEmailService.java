package com.tanjiaming99.service;

import com.tanjiaming99.model.entity.Email;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:26
 **/
public interface IEmailService {
    Boolean sendEmail(Email email);

}
