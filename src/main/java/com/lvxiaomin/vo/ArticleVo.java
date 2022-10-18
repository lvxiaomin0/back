package com.lvxiaomin.vo;

import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @Author: Ming
 * @Date: 2022/10/18 16:23
 */
@Data
public class ArticleVo extends Article {
    List<Article> article;
    User user;
}
