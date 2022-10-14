package com.lvxiaomin.MyException;

/**
 * @Author: Ming
 * @Date: 2022/10/13 22:29
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
