package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.ArticleType;
import com.lvxiaomin.service.ArticleTypeService;
import com.lvxiaomin.mapper.ArticleTypeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/** 文章类型
* @author Ming
* @description 针对表【article_type】的数据库操作Service实现
* @createDate 2022-08-07 15:34:19
*/
@Service
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper, ArticleType>
    implements ArticleTypeService{
    @Autowired
    private ArticleTypeMapper articleTypeMapper;


    /**
     * 写入文章类型
     * @param articleDto articleDto
     * @return null
     */
    @Override
    public Map<String, ArticleType> addArticleType(ArticleDto articleDto) {
        ArticleType articleType = new ArticleType();
        BeanUtils.copyProperties(articleDto,articleType);
        articleTypeMapper.insert(articleType);
        return null;
    }
}




