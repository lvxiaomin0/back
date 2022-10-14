package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Admin;
import com.lvxiaomin.service.AdminService;
import com.lvxiaomin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Ming
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-08-07 15:33:52
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getUser(String email, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_login_name",email)
                .eq("admin_login_password",password);
        Admin admin = adminMapper.selectOne(wrapper);
        return admin;
    }




}




