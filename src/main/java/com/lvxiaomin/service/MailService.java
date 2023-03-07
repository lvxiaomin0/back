package com.lvxiaomin.service;

import com.lvxiaomin.utils.AjaxJson;

/**
 * @Author: Ming
 * @Date: 2023/3/1 15:25
 */
public interface MailService {
    AjaxJson sendCode(String mailAddress);
}
