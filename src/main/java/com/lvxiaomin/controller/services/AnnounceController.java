package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Announcement;
import com.lvxiaomin.mapper.AnnouncementMapper;
import com.lvxiaomin.service.AnnouncementService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.AnnouncementVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**流动消息管理
 * @Author: Ming
 * @Date: 2023/3/30 20:15
 */
@RestController
@RequestMapping("/announce")
public class AnnounceController {

    @Resource
    private AnnouncementService announcementService;

    @Resource
    private AnnouncementMapper announcementMapper;
    /**
     * 获取流动 消息
     * @return List
     */
    @GetMapping("/get-announce")
    public List<Announcement> getAnnounceList(){
        List<Announcement> announcementList = announcementService.getAnnounce();
        return announcementList;
    }

    /**
     * admin-setAnnounce-info
     * @param announcementVo
     * @return AjaxJson
     */
    @PostMapping("/set-announce")
    public AjaxJson setAnnounce(@RequestBody @Valid AnnouncementVo announcementVo){
        String announce = announcementService.addAnnounce(announcementVo);
        return AjaxJson.getSuccess(announce);
    }


    /**
     * admin-delAnnounce
     * @param id
     * @return
     */
    @GetMapping("/del-announce")
    public AjaxJson delAnnounce(int id){
        int deleteById = announcementMapper.deleteById(id);
        return AjaxJson.getSuccess(String.valueOf(deleteById));
    }
}
