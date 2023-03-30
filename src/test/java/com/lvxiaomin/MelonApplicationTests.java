package com.lvxiaomin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lvxiaomin.entity.Message;
import com.lvxiaomin.mapper.MessageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MelonApplicationTests {

    @Resource
    private MessageMapper messageMapper;

    @Test
    void contextLoads() {
//        String userpwd = "123456";
//        String s = DigestUtils.md5DigestAsHex(userpwd.getBytes());
//        System.out.println("MD5加密："+s);
//        Page<Message> message = messageService.getMessage();
//        System.out.println(message.getRecords());
        Page<Message> page = new Page<>(0, 3);
        Page<Message> messagePage = messageMapper.selectPage(page, null);
        List<Message> messageList = messagePage.getRecords();
        for (Message message: messageList){
            System.out.println(message);
        }

    }
}
