package com.lvxiaomin.service;

import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Ming
* @description 针对表【article】的数据库操作Service
* @createDate 2022-08-07 15:34:13
*/
public interface ArticleService extends IService<Article> {
    List<Article> getArticle();

    Map<String,Article> addArticle(ArticleDto articleDto);

    void addArticleImageId(Long id);
    


}
