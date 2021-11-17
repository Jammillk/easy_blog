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
        System.out.println(stringEncryptor.encrypt("test"));
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
