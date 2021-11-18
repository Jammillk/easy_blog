package com.tanjiaming99;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EasyBlogApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;
    @Test
    public void testPassword(){
        String message = "test";
        System.out.println("明文：" + message);
        String encrypt = stringEncryptor.encrypt("test");
        System.out.println("密文：" + encrypt);
        String decrypt = stringEncryptor.decrypt(encrypt);
        System.out.println("解密：" + decrypt);
    }

    @Test
    void contextLoads() {
        String s = "abc";
        String s1 = new String("abc");
        String s2 = String.valueOf("abc");
        String s3 = new StringBuilder("abc").toString();
        String s4 = "a".concat("b").concat("c");
        String s5 = "a" + "b" + "c";
        String s6 = "abc".toString();

        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s == s4);
        System.out.println(s == s5);
        System.out.println(s == s6);
    }

}
