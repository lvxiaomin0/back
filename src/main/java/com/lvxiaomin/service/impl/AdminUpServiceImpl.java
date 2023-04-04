package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.dto.AdminUpVo;
import com.lvxiaomin.entity.AdminUp;
import com.lvxiaomin.service.AdminUpService;
import com.lvxiaomin.mapper.AdminUpMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 75494
* @description 针对表【admin_up】的数据库操作Service实现
* @createDate 2023-04-04 10:59:06
*/
@Service
public class AdminUpServiceImpl extends ServiceImpl<AdminUpMapper, AdminUp>
    implements AdminUpService{

    @Resource
    private AdminUpMapper adminUpMapper;


    @Override
    public int addFile(AdminUpVo adminUpVo) {
        AdminUp adminUp = new AdminUp();
        BeanUtils.copyProperties(adminUpVo,adminUp);
        int insert = adminUpMapper.insert(adminUp);
        return insert;
    }


    @Override
    public List<AdminUp> getAdminUpList() {
        List<AdminUp> adminUpList = adminUpMapper.selectList(null);
        return adminUpList;
    }
}




