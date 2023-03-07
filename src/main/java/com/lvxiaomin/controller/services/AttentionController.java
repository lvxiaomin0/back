package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Attention;
import com.lvxiaomin.service.AttentionService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Ming
 * @Date: 2023/2/16 13:03
 */
@RestController
@RequestMapping("/attention")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    @PostMapping("set-attention")
    public AjaxJson setAttention(@RequestBody Attention attention,boolean whetherAtt){
        attentionService.setAttention(attention,whetherAtt);
        return AjaxJson.getSuccess();
    }

    @GetMapping("get-attention")
    public AjaxJson getAttention(int userId){
        List<Attention> attentionUser = attentionService.getAttentionUser(userId);
        return AjaxJson.getSuccessArray(attentionUser);
    }

    @GetMapping("get-attentionCount")
    public AjaxJson getAttCount(int userId){
        int count = attentionService.getAttentionCount(userId);
        return AjaxJson.getSuccessData(count);
    }
}
