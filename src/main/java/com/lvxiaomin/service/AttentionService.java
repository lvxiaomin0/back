package com.lvxiaomin.service;

import com.lvxiaomin.entity.Attention;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.AttentionStatusVo;

import java.util.List;

/**
* @author Ming
* @description 针对表【attention】的数据库操作Service
* @createDate 2022-08-07 15:34:24
*/
public interface AttentionService extends IService<Attention> {
    /**
     * 用户关注
     * @param attention
     * @return
     */
    AjaxJson setAttention(Attention attention);

    /**
     * 获取关注量
     * @param userId
     * @return
     */
    int getAttentionCount(int userId);


    /**
     * 获取关注用户
     * @param userId
     * @return List
     */
    List<Attention> getAttentionUser(int userId);

    /**
     * 获取默认关注状态
     * @param attentionStatusVo
     * @return
     */
    boolean getAttentionStatus(AttentionStatusVo attentionStatusVo);
}
