package com.tanjiaming99.password;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/17 17:24
 * @description 数据库中的密码都以下面这种方式加密，
 * 运行它，然后它会根据jasypt.encryptor.password的密钥进行加密
 * 得到的那串密钥即可放入数据库中，即ENC(XXXXXX)
 */
@SpringBootTest
public class PasswordTest {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void testPassword(){
        System.out.println(stringEncryptor.encrypt("test"));
    }
}
