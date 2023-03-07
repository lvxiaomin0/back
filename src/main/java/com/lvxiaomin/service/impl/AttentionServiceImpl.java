package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Attention;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.AttentionService;
import com.lvxiaomin.mapper.AttentionMapper;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author Ming
* @description 针对表【attention】的数据库操作Service实现
* @createDate 2022-08-07 15:34:24
*/
@Service
public class AttentionServiceImpl extends ServiceImpl<AttentionMapper, Attention>
    implements AttentionService{

    @Autowired
    private AttentionMapper attentionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Attention setAttention(Attention attention,boolean whetherAtt) {
        if (!whetherAtt){
            attentionMapper.insert(attention);

        }else {
            QueryWrapper<Attention> attentionQueryWrapper = new QueryWrapper<>();
            attentionQueryWrapper.eq("att_user_id",attention.getAttUserId())
                            .eq("att_author_id",attention.getAttAuthorId());
            attentionMapper.delete(attentionQueryWrapper);
        }
        return null;
    }

    @Override
    public int getAttentionCount(int userId) {
        LambdaQueryWrapper<Attention> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Attention::getAttUserId,userId);
        Long selectCount = attentionMapper.selectCount(lambdaQueryWrapper);
        int parseInt = Integer.parseInt(String.valueOf(selectCount));
        return parseInt;
    }

    /**
     * 通过用户id 查询关注用户信息
     * @param userId
     * @return
     */
    @Override
    public List<Attention> getAttentionUser(int userId) {
        LambdaQueryWrapper<Attention> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Attention::getAttAuthorId)
                         .eq(Attention::getAttUserId,userId);
        List<Attention> attentionList = attentionMapper.selectList(lambdaQueryWrapper);
        for (Attention attention : attentionList){
            User user = userMapper.selectById(attention.getAttAuthorId());
            HashMap<String, User> map = new HashMap<>();
            user.setUserPassword(null);
            map.put("user",user);
            attention.setMap(map);
        }
        return attentionList;
    }

}




