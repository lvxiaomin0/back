package com.lvxiaomin.service;

import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.ArticleType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Ming
* @description 针对表【article_type】的数据库操作Service
* @createDate 2022-08-07 15:34:19
*/
public interface ArticleTypeService extends IService<ArticleType> {
    Map<String,ArticleType> addArticleType(ArticleDto articleDto);
}
