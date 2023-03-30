package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Announcement;
import com.lvxiaomin.service.AnnouncementService;
import com.lvxiaomin.mapper.AnnouncementMapper;
import com.lvxiaomin.vo.AnnouncementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Ming
* @description 针对表【announcement】的数据库操作Service实现
* @createDate 2023-03-30 19:56:27
*/
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService{


    @Resource
    private AnnouncementMapper announcementMapper;

    /**
     * 流动消息写入
     * @param announcementVo
     * @return String
     */
    @Override
    public String addAnnounce(AnnouncementVo announcementVo) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(announcementVo,announcement);
        int insert = announcementMapper.insert(announcement);
        if (insert == 1) {
            return "发布成功";
        }
        return "出现未知错误！！！";

    }


    /**
     * 获取流动消息
     * @return List
     */
    @Override
    public List<Announcement> getAnnounce() {
        List<Announcement> announcementList = announcementMapper.selectList(null);
        return announcementList;
    }
}




