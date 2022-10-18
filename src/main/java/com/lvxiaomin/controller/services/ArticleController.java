package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Ming
 * @Date: 2022/10/17 10:02
 */
@RestController
@RequestMapping("service")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("get-article")
    public AjaxJson getArticle(){
        List<Article> articleList = articleService.getArticle();

        return AjaxJson.getSuccessData(articleList);
    }
}
