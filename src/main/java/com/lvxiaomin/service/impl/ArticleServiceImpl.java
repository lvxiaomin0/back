package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author Ming
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-08-07 15:34:13
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




