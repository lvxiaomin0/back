package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Attention;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.AttentionMapper;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.AttentionService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.AttentionStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**用户关注
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

    @Resource
    private StringRedisTemplate template;

    /**
     * 用户关注
     * @param attention
     * @return
     */
    @Override
    public AjaxJson setAttention(Attention attention) {

        LambdaQueryWrapper<Attention> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(Attention::getAttUserId,attention.getAttUserId())
                .eq(Attention::getAttAuthorId,attention.getAttAuthorId());
        Attention attentionOne = attentionMapper.selectOne(userLambdaQueryWrapper);
        //查询粉丝数
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUserId, attention.getAttAuthorId())
                .select(User::getUserFans);
        User selectOne = userMapper.selectOne(userQueryWrapper);
        //更新用户表粉丝字段
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getUserId,attention.getAttAuthorId());
        User user = new User();
        if (attentionOne == null){
            int insertPoint = attentionMapper.insert(attention);
            if (insertPoint ==1 ){
                //写入Redis
                template.opsForValue().set("attention", String.valueOf(attention));

            }

            user.setUserFans(selectOne.getUserFans()+1);
            userMapper.update(user,updateWrapper);

            return AjaxJson.get(201,"关注成功");

        }else {
            QueryWrapper<Attention> attentionQueryWrapper = new QueryWrapper<>();
            attentionQueryWrapper.eq("att_user_id",attention.getAttUserId())
                    .eq("att_author_id",attention.getAttAuthorId());
            int deletePoint = attentionMapper.delete(attentionQueryWrapper);
            if (deletePoint == 1){
                template.delete("attention");
            }

            user.setUserFans(selectOne.getUserFans()-1);
            userMapper.update(user,updateWrapper);
            return AjaxJson.get(202,"取消关注");
        }

    }

    /**
     * 获取关注量
     * @param userId userId
     * @return parseInt
     */
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
     * @param userId userId
     * @return List
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


    @Override
    public boolean getAttentionStatus(AttentionStatusVo attentionStatusVo) {
        LambdaQueryWrapper<Attention> attentionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        attentionLambdaQueryWrapper.eq(Attention::getAttUserId,attentionStatusVo.getAttUserId())
                        .eq(Attention::getAttAuthorId,attentionStatusVo.getAttAuthorId());
        Attention attention = attentionMapper.selectOne(attentionLambdaQueryWrapper);
        return attention != null;
    }

}




