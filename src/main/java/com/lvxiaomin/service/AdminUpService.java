package com.lvxiaomin.service;

import com.lvxiaomin.dto.AdminUpVo;
import com.lvxiaomin.entity.AdminUp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75494
* @description 针对表【admin_up】的数据库操作Service
* @createDate 2023-04-04 10:59:06
*/
public interface AdminUpService extends IService<AdminUp> {
    /**
     * URl 写入
     * @param adminUpVo
     * @return
     */
    int addFile(AdminUpVo adminUpVo);

    /**
     * 获取上传List
     * @return
     */
    List<AdminUp> getAdminUpList();
}
