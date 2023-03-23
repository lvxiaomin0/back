package com.lvxiaomin.controller.user;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.dto.UserRegisterDto;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.utils.TencentCosUtil;
import com.lvxiaomin.vo.UpdateUserVo;
import com.lvxiaomin.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userDto
     * @return
     */
    @RequestMapping("/login")
    public AjaxJson userLogin(@RequestBody @Valid UserDto userDto) {
        //加密
        String userPwdMd5 = DigestUtils.md5DigestAsHex(userDto.getUserPassword().getBytes());
        AjaxJson user = userService.getUser(userDto.getUserEmail(), userPwdMd5);
        int code = user.getCode();
        if (code == 5002 ||code == 5003){
            return AjaxJson.getErrorData(user);
        }
            User data = (User) user.getData();
            StpUtil.login(data.getUserId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            Map<String, Object> map = new HashMap<>();
            map.put("user",data);
            map.put("tokenInfo",tokenInfo);
            return AjaxJson.getSuccessData(map);


    }

    /**
     * 用户注册
     * @param userRegisterDto
     * @return
     */
    @PostMapping("/register")
    public AjaxJson register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        boolean addUser = userService.addUser(userRegisterDto);
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

        //用户头像
        String userAvatar = null;
        if (userId != 0 && avatar!=null) {
            userAvatar = TencentCosUtil.uploadFile(avatar);
        }
        UpdateUserVo updateUserVo = new UpdateUserVo();
        User user = new User();
        updateUserVo.setUserId(userId);
        updateUserVo.setUserImg(userAvatar);
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
