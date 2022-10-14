package com.lvxiaomin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelonApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {


    }
}
