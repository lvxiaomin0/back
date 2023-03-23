package com.lvxiaomin.service;

import com.lvxiaomin.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.vo.CollectStatusVo;

/**
* @author Ming
* @description 针对表【collect】的数据库操作Service
* @createDate 2022-08-07 15:34:28
*/
public interface CollectService extends IService<Collect> {

    /**
     * 获取点赞原始状态
     * @return
     */
    boolean getCollectStatus(CollectStatusVo collectStatusVo);
}
