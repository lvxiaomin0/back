package com.lvxiaomin.MyException;

/**
 * @Author: Ming
 * @Date: 2023/2/16 22:44
 */
public class AttentionException extends Exception{
    public AttentionException(){ }

    public AttentionException(String message) {
        super(message);
    }
}
