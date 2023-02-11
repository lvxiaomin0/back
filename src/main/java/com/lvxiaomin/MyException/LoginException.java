package com.lvxiaomin.MyException;

/** 登录自定义异常
 * @Author: Ming
 * @Date: 2023/01/13 22:29
 * /**
 * * Method description
 * *
 * * @throws Login runtime
 *
 */
public class LoginException extends Exception{
    public LoginException(){ }

    public LoginException(String message) {
        super(message);
    }
}
