package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**  用户服务
* @author Ming
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-07 15:34:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserVo getUser(String email, String password) throws LoginException {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(email != null,User::getUserEmail,email);
            User user = userMapper.selectOne(lambdaQueryWrapper);
            if (user == null){
                throw new LoginException("邮箱不存在");
            } else if (!user.getUserPassword().equals(password)) {
                throw new LoginException("用户名或密码不正确");
            }else {
                UserVo userVo = new UserVo();
                userVo.setUser(user);
                return userVo;
            }

    }



    @Override
    public boolean addUser(UserDto userDto) throws NotFoundException {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        int insert = userMapper.insert(user);
        if (insert >=0){
            return true;
        }else {
            throw new NotFoundException("用户注册失败！");
        }

    }

    @Override
    public User getUserName(String email) throws NotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_email",email);
        User user = userMapper.selectOne(wrapper);
        if (!Optional.ofNullable(user).isPresent()){
            throw new NotFoundException("邮箱可用！");
        }else {
            throw new NotFoundException("邮箱已注册不可用！");
        }

    }
}




