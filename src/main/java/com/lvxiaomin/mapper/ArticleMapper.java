package com.lvxiaomin.mapper;

import com.lvxiaomin.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ming
 * @description 针对表【article】的数据库操作Mapper
 * @createDate 2022-08-07 15:34:13
 * @Entity generator.domain.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




