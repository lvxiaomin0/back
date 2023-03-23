package com.lvxiaomin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class MelonApplicationTests {


    @Test
    void contextLoads() {
        String userpwd = "123456";
        String s = DigestUtils.md5DigestAsHex(userpwd.getBytes());
        System.out.println("MD5加密："+s);


    }
}
