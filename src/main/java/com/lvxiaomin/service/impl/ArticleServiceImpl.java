package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.ArticleMapper;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param  id artTppeId
     * @return mapPage
     */
    @Override
    public List<Article> getArticleById(int id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getArtTypeId, id)
                .gt(Article::getArtComNum, 10);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return getArticles(articleList);
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




