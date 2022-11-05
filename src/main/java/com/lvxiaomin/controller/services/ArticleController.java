package com.lvxiaomin.controller.services;

import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.service.ArticleTypeService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("get-article")
    public AjaxJson getArticle(){
        List<Article> articleList = articleService.getArticle();

        return AjaxJson.getSuccessData(articleList);
    }

    @PostMapping("add-article")
    public AjaxJson addArticle(@RequestBody @Valid ArticleDto articleDto){
        //写入文章
        articleService.addArticle(articleDto);
        //写入文章类型
        articleTypeService.addArticleType(articleDto);
        return AjaxJson.getSuccessData(articleDto);
    }
}
