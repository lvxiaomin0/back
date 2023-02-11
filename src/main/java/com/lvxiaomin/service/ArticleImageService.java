package com.lvxiaomin.service;

import com.lvxiaomin.entity.ArticleImage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Ming
* @description 针对表【article_image】的数据库操作Service
* @createDate 2023-02-10 02:37:03
*/
public interface ArticleImageService extends IService<ArticleImage> {

    void addArticleImage(String imageUrl);
}
