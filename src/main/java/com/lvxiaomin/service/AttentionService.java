package com.lvxiaomin.service;

import com.lvxiaomin.entity.Attention;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Ming
* @description 针对表【attention】的数据库操作Service
* @createDate 2022-08-07 15:34:24
*/
public interface AttentionService extends IService<Attention> {
    Attention setAttention(Attention attention,boolean whetherAtt);
    int getAttentionCount(int userId);

    List<Attention> getAttentionUser(int userId);
}
