package com.lvxiaomin.service;

import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.CodeUpdatePwdVo;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;

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
    UserVo getUser(String email, String password) throws LoginException;

    /**
     * 用户注册
     * @param userDto
     * @return
     * @throws NotFoundException
     */
    boolean addUser(UserDto userDto) throws NotFoundException;

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
     * 忘记密码接口
     * @param codeUpdatePwdVo
     * @return
     */
    AjaxJson forgetUpdateSecret(CodeUpdatePwdVo codeUpdatePwdVo);









}
