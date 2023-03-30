package com.lvxiaomin.service;

import com.lvxiaomin.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.vo.AnnouncementVo;

import java.util.List;

/**
* @author Ming
* @description 针对表【announcement】的数据库操作Service
* @createDate 2023-03-30 19:56:27
*/
public interface AnnouncementService extends IService<Announcement> {
        /**
         * 流动消息写入
         * @param announcementVo
         * @return String
         */
        String addAnnounce(AnnouncementVo announcementVo);

        /**
         * 获取流动消息
         * @return List
         */
        List<Announcement> getAnnounce();
}
