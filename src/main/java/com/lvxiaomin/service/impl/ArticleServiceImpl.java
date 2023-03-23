package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.Collect;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.ArticleMapper;
import com.lvxiaomin.mapper.CollectMapper;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.GetArticleByIdVo;
import com.lvxiaomin.vo.UpdateArtLikeNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 文章业务
* @author Ming
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-08-07 15:34:13
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Resource
    private CollectMapper collectMapper;



    /**
     * 获取用户及其帖子
     * @return List
     */
    @Override
    public List<Article> getArticle() {
        List<Article> articleList = articleMapper.selectList(null);
        return getArticles(articleList);
    }

    /**
     * 添加新帖子
     * @param article article
     * @return null
     */
    @Override
    public Map<String, Article> addArticle(Article article) {
        articleMapper.insert(article);
        return null;
    }

    /**
     * 获取文章类型为寻物帖
     * @param  artTypeId artTypeId
     * @return mapPage
     */
    @Override
    public List<Article> getArticleById(int artTypeId) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getArtTypeId, artTypeId)
                .gt(Article::getArtComNum, 10);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return getArticles(articleList);
    }

    /**
     * 文章热度加10，访问量加1
     * @param artId
     * @return
     */
    @Override
    public AjaxJson updateArtHotAndArtView(int artId) {
        //查询原始热度及访问量
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Article::getArtId,artId);
        Article selectOne = articleMapper.selectOne(lambdaQueryWrapper);

        //更新累加热度及访问量
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getArtId,artId);
        Article article = new Article();
        article.setArtHotNum(selectOne.getArtHotNum()+10);
        article.setArtView(selectOne.getArtView()+1);
        articleMapper.update(article,updateWrapper);
        return null;
    }


    /**
     * 用户点击喜欢，文章喜欢量加一
     * @param
     * @return
     */
    @Override
    public AjaxJson updateArtLikeNum(UpdateArtLikeNumVo updateArtLikeNumVo) {
        LambdaQueryWrapper<Collect> collectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        collectLambdaQueryWrapper.eq(Collect::getColArtId,updateArtLikeNumVo.getArtId())
                .eq(Collect::getColUserId,updateArtLikeNumVo.getUserId());
        Collect collect = collectMapper.selectOne(collectLambdaQueryWrapper);
        //待优化
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Article::getArtId,updateArtLikeNumVo.getArtId());
        Article selectOne = articleMapper.selectOne(lambdaQueryWrapper);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getArtId,updateArtLikeNumVo.getArtId());
        Article article = new Article();
        if (collect == null){
            //文章喜欢加一
            article.setArtLikeNum(selectOne.getArtLikeNum()+1);
            articleMapper.update(article,updateWrapper);
            //写入点赞表
            Collect collectInfo = new Collect();
            collectInfo.setColArtId((long) updateArtLikeNumVo.getArtId());
            collectInfo.setColUserId((long) updateArtLikeNumVo.getUserId());
            collectMapper.insert(collectInfo);
            return AjaxJson.get(201,"点赞成功");
        }else {
            //文章喜欢减一
            article.setArtLikeNum(selectOne.getArtLikeNum()-1);
            articleMapper.update(article,updateWrapper);
            //删除点赞表
            LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Collect::getColUserId,updateArtLikeNumVo.getUserId());
            collectMapper.delete(queryWrapper);
            return AjaxJson.get(202,"取消点赞");
        }

    }

    /**
     * 提取方法 获取文章及用户信息
     * @return articleList
     */
    private List<Article> getArticles(List<Article> articleList) {
        for (Article article : articleList) {
            User user = userMapper.selectById(article.getArtUserId());
            HashMap<String, User> map = new HashMap<>();
            user.setUserPassword(null);
            map.put("user",user);
            article.setMap(map);
        }
        return articleList;
    }


}




