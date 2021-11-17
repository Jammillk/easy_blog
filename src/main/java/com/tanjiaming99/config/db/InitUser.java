package com.tanjiaming99.config.db;

import com.tanjiaming99.model.entity.AdminUser;
import com.tanjiaming99.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/17 17:04
 * @description
 */
@Component
public class InitUser {
    @Autowired
    private IAdminUserService adminUserService;

    /**
     * 初始用户
     */
    @PostConstruct
    public void InsertInitUserToDB() {
        if(Objects.isNull(adminUserService.getById(1))){
            return ;
        }
        AdminUser user = AdminUser.builder()
                .adminUserId(1)
                .loginUserName("root")
                .loginPassword("admin")
                .nickName("小站管理员").build();
        adminUserService.save(user);
    }
}
