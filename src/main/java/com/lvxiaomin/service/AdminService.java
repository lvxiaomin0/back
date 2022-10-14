package com.lvxiaomin.service;

import com.lvxiaomin.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Ming
* @description 针对表【admin】的数据库操作Service
* @createDate 2022-08-07 15:33:52
*/
public interface AdminService extends IService<Admin> {
   Admin getUser(String email, String password);


}
