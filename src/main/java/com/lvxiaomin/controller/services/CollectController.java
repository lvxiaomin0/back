package com.lvxiaomin.controller.services;

import com.lvxiaomin.service.CollectService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.CollectStatusVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Ming
 * @Date: 2023/3/14 15:41
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Resource
    private CollectService collectService;


    @PostMapping("/get-collectStatus")
    public AjaxJson getCollectStatus(@RequestBody CollectStatusVo collectStatusVo){
        boolean collectStatus = collectService.getCollectStatus(collectStatusVo);
        return AjaxJson.getSuccessData(collectStatus);
    }
}
