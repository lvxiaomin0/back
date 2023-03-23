package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Attention;
import com.lvxiaomin.service.AttentionService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.AttentionStatusVo;
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

    /**
     * 用户点击关注
     * @param attention
     * @return
     */
    @PostMapping("/set-attention")
    public AjaxJson setAttention(@RequestBody Attention attention){
        AjaxJson ajaxJson = attentionService.setAttention(attention);
        return AjaxJson.getSuccessData(ajaxJson);
    }
    /**
     * 获取关注用户
     * @param userId
     * @return
     */
    @GetMapping("/get-attention")
    public AjaxJson getAttention(int userId){
        List<Attention> attentionUser = attentionService.getAttentionUser(userId);
        return AjaxJson.getSuccessArray(attentionUser);
    }

    @GetMapping("/get-attentionCount")
    public AjaxJson getAttCount(int userId){
        int count = attentionService.getAttentionCount(userId);
        return AjaxJson.getSuccessData(count);
    }

    /**
     * 获取用户关注状态
     * @param attentionStatusVo
     * @return
     */
    @PostMapping("/get-attentionStatus")
    public AjaxJson getAttentionStatus(@RequestBody AttentionStatusVo attentionStatusVo){
        boolean attentionStatus = attentionService.getAttentionStatus(attentionStatusVo);
        return AjaxJson.getSuccessData(attentionStatus);
    }
}
