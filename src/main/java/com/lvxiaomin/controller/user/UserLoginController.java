package com.lvxiaomin.controller.user;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/get-user")
    public AjaxJson getUser(@RequestBody UserDto userDto) throws NotFoundException {
        userService.getUserName(userDto.getUserEmail());
        return AjaxJson.getSuccess();

    }
}
