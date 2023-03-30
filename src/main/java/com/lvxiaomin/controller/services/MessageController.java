package com.lvxiaomin.controller.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lvxiaomin.entity.Message;
import com.lvxiaomin.service.MessageService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.MessagePageVo;
import com.lvxiaomin.vo.MessageVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/** 用户留言
 * @Author: Ming
 * @Date: 2023/3/30 14:16
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;


    @PostMapping("/set-message")
    public AjaxJson setMessage(@RequestBody @Valid MessageVo messageVo){
        String message = messageService.addMessage(messageVo);
        return AjaxJson.getSuccess(message);

    }

    @GetMapping("get-message")
    public IPage<Message> getMessage(MessagePageVo messagePageVo){
        IPage<Message> message = messageService.getMessage(messagePageVo.getCurrentPage(),
                messagePageVo.getPageSize());
        return message;
    }
}
