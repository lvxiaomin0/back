package com.lvxiaomin.MyException;

/** 文件上传自定义异常
 * @Author: Ming
 * @Date: 2023/1/14 20:21
 */
public class UploadFileException extends Exception{

    public UploadFileException(){}

    public UploadFileException(String message){
        super(message);
    }

}
