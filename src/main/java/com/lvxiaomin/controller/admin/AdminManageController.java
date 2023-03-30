package com.lvxiaomin.controller.admin;

import com.lvxiaomin.entity.User;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**管理员操作
 * @Author: Ming
 * @Date: 2023/2/18 23:53
 */
@RestController
@RequestMapping("/admin")
public class AdminManageController {

    @Resource
    private UserService userService;

    @PostMapping("/update-everyInfo")
    public AjaxJson updateEveryInfo(){
        return AjaxJson.getSuccess("更新成功");
    }


    /**
     * admin-getUserInfo
     * @return userList
     */
    @GetMapping("/get-userInfo")
    public List<User> getUserInfo(){
        List<User> userList = userService.adminGetUserInfo();
        return userList;
    }
}
