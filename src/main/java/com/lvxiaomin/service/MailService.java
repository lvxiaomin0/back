package com.lvxiaomin.service;

import com.lvxiaomin.utils.AjaxJson;

/**
 * @Author: Ming
 * @Date: 2023/3/1 15:25
 */
public interface MailService {

    /**
     * 发送验证码
     * @param mailAddress
     * @return AjaxJson
     */
    AjaxJson sendCode(String mailAddress);
}
