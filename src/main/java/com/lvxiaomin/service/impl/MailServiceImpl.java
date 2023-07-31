package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.MailService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/** 忘记密码邮箱验证
 * @Author: Ming
 * @Date: 2023/3/1 15:28
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserMapper userMapper;

    @Value("${spring.mail.username}")
    private String mailUserName;


    @Override
    public AjaxJson sendCode(String mailAddress) {
        //非空校验
        if (null == mailAddress || "".equals(mailAddress)) return AjaxJson.getError("邮箱不能为空！");

        //账号存在校验
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserEmail,mailAddress);
        User userEmail = userMapper.selectOne(lambdaQueryWrapper);
        if (null == userEmail) return AjaxJson.getError("邮箱不存在！");
        if (!userEmail.getUserEmail().equals(mailAddress)) return AjaxJson.getError("输入的邮箱与账号不符");

        //随机验证码
        String value = String.valueOf(new Random().nextInt(899999) + 100000);
        ValueOperations<String, String> valueOperations = template.opsForValue();

        //验证码存入Redis
        valueOperations.set("codes", value,10, TimeUnit.MINUTES);


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title></title></head><body>");
        stringBuilder.append("您好<br/>");
        stringBuilder.append("您的验证码是：").append(value).append("<br/>");
        stringBuilder.append("您可以复制此验证码并返回论坛找回密码页面，以验证您的邮箱。<br/>");
        stringBuilder.append("此验证码只能使用一次，在");
        stringBuilder.append("10");
        stringBuilder.append("分钟内有效。验证成功则自动失效。<br/>");
        stringBuilder.append("如果您没有进行上述操作，请忽略此邮件。");

        //SimpleMailMessage是一个比较简易的邮件封装，支持设置一些比较简单内容
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件标题
        message.setSubject("XueMing给你发验证码了");
        //设置邮件内容
        message.setText(String.valueOf(stringBuilder));
        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
        message.setTo(mailAddress);
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom(mailUserName);
        //OK，万事俱备只欠发送
        mailSender.send(message);

        return AjaxJson.getSuccess("验证码发送成功");
    }
}
