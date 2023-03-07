package com.lvxiaomin.controller.user;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.utils.TencentCosUtil;
import com.lvxiaomin.vo.UpdateUserVo;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userDto
     * @return
     */
    @RequestMapping("/login")
    public AjaxJson userLogin(@RequestBody @Valid UserDto userDto) throws LoginException {
        UserVo userVo = userService.getUser(userDto.getUserEmail(), userDto.getUserPassword());
        if (userVo.getUser().getUserEmail().equals(userDto.getUserEmail()) &&
                userVo.getUser().getUserPassword().equals(userDto.getUserPassword())){
            StpUtil.login(userVo.getUser().getUserId());
            //返回token到前端
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            userVo.getUser().setUserPassword(null);
            Map<String, Object> map = new HashMap<>();
            map.put("user",userVo.getUser());
            map.put("tokenInfo",tokenInfo);
            return AjaxJson.getSuccessData(map);
        }else {
            return AjaxJson.getError();
        }

    }

    /**
     * 用户注册
     * @param userDto
     * @return
     */
    @PostMapping("/register")
    public AjaxJson register(@RequestBody @Valid UserDto userDto) throws NotFoundException {
        boolean addUser = userService.addUser(userDto);
        if (addUser) {
            return AjaxJson.getSuccess("Register success!");
        } else {
            return AjaxJson.getError("Email and password cannot be empty！");
        }
    }


    /**
     * 判断邮箱是否可用
     * @param userDto
     * @return
     */
    @PostMapping(value = "/get-user")
    public AjaxJson getUser(@RequestBody UserDto userDto)  {
        AjaxJson userName = userService.getUserName(userDto.getUserEmail());
        return AjaxJson.getSuccess(String.valueOf(userName.getMsg()));


    }

    /**
     * 用户更新个人信息
     * @param userId
     * @param userEmail
     * @param userName
     * @param userSex
     * @param userShow
     * @param userBlog
     * @param userPhone
     * @param avatar
     * @return
     * @throws Exception
     */
    @PostMapping("/update-user")
    public AjaxJson updateUser(
            @RequestParam(value = "userId")
            int userId,
            @RequestParam(value = "userEmail",required = false)
            String userEmail,
            @RequestParam(value = "userName",required = false)
            String userName,
            @RequestParam(value = "userSex",required = false)
            String userSex,
            @RequestParam(value = "userShow",required = false)
            String userShow,
            @RequestParam(value = "userBlog",required = false)
            String userBlog,
            @RequestParam(value = "userPhone",required = false)
            String userPhone,
            @RequestParam(value = "avatar",required = false) MultipartFile avatar) throws Exception {
        /**
         * 用户头像
         */

        String userAvatar = null;
        if (userId != 0 && avatar!=null) {
            userAvatar = TencentCosUtil.uploadFile(avatar);
        }
        UpdateUserVo updateUserVo = new UpdateUserVo();
        User user = new User();
        updateUserVo.setUserId(userId);
        updateUserVo.setUserImg(userAvatar);
        updateUserVo.setUserEmail(userEmail);
        updateUserVo.setUserName(userName);
        updateUserVo.setUserSex(userSex);
        updateUserVo.setUserShow(userShow);
        updateUserVo.setUserBlog(userBlog);
        updateUserVo.setUserPhone(userPhone);
        BeanUtils.copyProperties(updateUserVo,user);
        User updateUserInfo = userService.updateUserInfo(user);
        return AjaxJson.getSuccess(userAvatar,updateUserInfo);
    }
}
