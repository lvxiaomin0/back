package com.lvxiaomin.service;

import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;

/**
* @author Ming
* @description 针对表【user】的数据库操作Service
* @createDate 2022-08-07 15:34:38
*/
public interface UserService extends IService<User> {
    UserVo getUser(String email, String password) throws LoginException;

    boolean addUser(UserDto userDto) throws NotFoundException;

    User getUserName(String email) throws NotFoundException;




}
