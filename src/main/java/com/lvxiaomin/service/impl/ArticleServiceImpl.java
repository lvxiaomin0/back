package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.ArticleMapper;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.ArticleService;
import org.springframework.beans.BeanUtils;
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
        for (Article article : articleList) {
            User user = userMapper.selectById(article.getArtUserId());
            HashMap<String, User> map = new HashMap<>();
            user.setUserPassword(null);
            map.put("user",user);
            article.setMap(map);

        }
        return articleList;
    }

    /**
     * 添加新帖子
     * @param
     * @return null
     */
    @Override
    public Map<String, Article> addArticle(Article article) {
        articleMapper.insert(article);
        return null;
    }


}




