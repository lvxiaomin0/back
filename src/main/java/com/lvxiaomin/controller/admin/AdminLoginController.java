package com.lvxiaomin.controller.admin;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lvxiaomin.entity.Admin;
import com.lvxiaomin.service.AdminService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.AdminVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
  *管理员登录
  * @Author: Ming
  * @Date: 2022/9/22 17:11
  * @Keep your temper
  */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {
    @Resource
    AdminService adminService;


    @PostMapping("/login")
    public AjaxJson login(@RequestBody @Valid AdminVo adminVo) {
        Admin user = adminService.getUser(adminVo.getAdminLoginName(), adminVo.getAdminLoginPassword());

        if (user.getAdminLoginName().equals(adminVo.getAdminLoginName()) &&
                user.getAdminLoginPassword().equals(adminVo.getAdminLoginPassword())){
            StpUtil.login(user.getAdminId());
            //返回token到前端
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return AjaxJson.getSuccessData(tokenInfo);
        }else {
            return AjaxJson.getError();
        }


    }




}
