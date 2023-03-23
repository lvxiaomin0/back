package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Collect;
import com.lvxiaomin.service.CollectService;
import com.lvxiaomin.mapper.CollectMapper;
import com.lvxiaomin.vo.CollectStatusVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/** 用户点赞
* @author Ming
* @description 针对表【collect】的数据库操作Service实现
* @createDate 2022-08-07 15:34:28
*/
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect>
    implements CollectService{

    @Resource
    private CollectMapper collectMapper;

    @Override
    public boolean getCollectStatus(CollectStatusVo collectStatusVo) {
        LambdaQueryWrapper<Collect> collectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        collectLambdaQueryWrapper.eq(Collect::getColArtId,collectStatusVo.getArtId())
                .eq(Collect::getColUserId, collectStatusVo.getUserId());
        Collect collect = collectMapper.selectOne(collectLambdaQueryWrapper);
        if (collect == null){
            return false;
        }else {
            return true;
        }


    }
}




