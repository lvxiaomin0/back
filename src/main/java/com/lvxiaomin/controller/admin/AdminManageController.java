package com.lvxiaomin.controller.admin;

import com.lvxiaomin.utils.AjaxJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ming
 * @Date: 2023/2/18 23:53
 */
@RestController
@RequestMapping("/manager")
public class AdminManageController {

    @PostMapping("/update-everyInfo")
    public AjaxJson updateEveryInfo(){
        return AjaxJson.getSuccess("更新成功");
    }
}
