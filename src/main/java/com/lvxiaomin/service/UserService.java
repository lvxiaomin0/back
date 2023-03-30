package com.lvxiaomin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.dto.UserRegisterDto;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.CodeUpdatePwdVo;
import com.lvxiaomin.vo.UpdateUserPwd;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
* @author Ming
* @description 针对表【user】的数据库操作Service
* @createDate 2022-08-07 15:34:38
*/
public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     * @throws LoginException
     */
    AjaxJson getUser(String email, String password);

    /**
     * 用户注册
     * @param userRegisterDto
     * @return
     * @throws NotFoundException
     */
    boolean addUser(UserRegisterDto userRegisterDto);

    /**
     * 判断用户是否存在
     * @param email
     * @return
     * @throws NotFoundException
     */
    AjaxJson getUserName(String email);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    User updateUserInfo(User user);

    /**
     * 忘记密码验证接口
     * @param codeUpdatePwdVo
     * @return
     */
    AjaxJson forgetUpdateSecret(CodeUpdatePwdVo codeUpdatePwdVo);

    /**
     * 验证通过修改密码
     * @param updateUserPwd
     * @return
     */
    AjaxJson updateUserPwd(UpdateUserPwd updateUserPwd);




    /**
     * admin-getUserInfo
     * @return list
     */
    List<User> adminGetUserInfo();



}
