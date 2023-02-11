package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.ArticleImage;
import com.lvxiaomin.service.ArticleImageService;
import com.lvxiaomin.mapper.ArticleImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 75494
* @description 针对表【article_image】的数据库操作Service实现
* @createDate 2023-02-10 02:37:03
*/
@Service
public class ArticleImageServiceImpl extends ServiceImpl<ArticleImageMapper, ArticleImage>
    implements ArticleImageService{

    @Autowired
    private ArticleImageMapper articleImageMapper;
    @Override
    public void addArticleImage(String imageUrl) {
        ArticleImage articleImage = new ArticleImage();
        articleImage.setArtImage(imageUrl);
        articleImageMapper.insert(articleImage);
    }
}




