package com.lvxiaomin.controller.admin;

import com.lvxiaomin.dto.AdminUpVo;
import com.lvxiaomin.entity.AdminUp;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.AdminUpMapper;
import com.lvxiaomin.service.AdminUpService;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @Resource
    private AdminUpService adminUpService;

    @Resource
    private AdminUpMapper adminUpMapper;

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

    /**
     * 管理员上传文件
     * @param adminUpVo
     * @return
     */
    @PostMapping("/set-upFile")
    public AjaxJson setUpFile(@RequestBody @Valid AdminUpVo adminUpVo){
        int addFile = adminUpService.addFile(adminUpVo);
        return AjaxJson.getSuccess(String.valueOf(addFile));
    }


    /**
     * 删除
     * @param id
     * @return deleteById
     */
    @GetMapping("/del-upFile")
    public AjaxJson delUpFile(int id){
        int deleteById = adminUpMapper.deleteById(id);
        return AjaxJson.getSuccess(String.valueOf(deleteById));
    }

    /**
     * 获取上传文件
     * @return adminUpList
     */
    @GetMapping("/get-upFileList")
    public List<AdminUp> getFileList(){
        List<AdminUp> adminUpList = adminUpService.getAdminUpList();
        return adminUpList;
    }
}
