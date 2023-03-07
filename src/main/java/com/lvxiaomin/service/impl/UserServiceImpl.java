package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.MyException.LoginException;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.dto.UserDto;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.CodeUpdatePwdVo;
import com.lvxiaomin.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    @Autowired
    private StringRedisTemplate template;

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
    public AjaxJson getUserName(String email){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_email",email);
        User user = userMapper.selectOne(wrapper);
        if (!Optional.ofNullable(user).isPresent()){
            return AjaxJson.getSuccess("邮箱可用！");

        }else {
            return AjaxJson.getSuccess("邮箱已注册，邮箱不可用！");
        }

    }

    /** 更新用户信息
     * 更新用户信息
     * @param user
     * @return null
     */
    @Override
    public User updateUserInfo(User user) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getUserId,user.getUserId());
        userMapper.update(user,updateWrapper);
        return null;
    }



    @Override
    public AjaxJson forgetUpdateSecret(CodeUpdatePwdVo codeUpdatePwdVo) {
        //账号存在校验
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserEmail,codeUpdatePwdVo.getUserEmail());
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (null == user) return AjaxJson.getError("账号不存在");

        //验证码过期校验
        ValueOperations<String, String> operations = template.opsForValue();
        Long expire = operations.getOperations().getExpire(codeUpdatePwdVo.getSecurityCode());
        if (0 == expire) return AjaxJson.getError("验证码已过期");

        //验证码正确性校验
        String codes = operations.get("codes");
        if (!codeUpdatePwdVo.getSecurityCode().equals(codes)) return AjaxJson.getError("验证码错误");

        return null;
    }
}




