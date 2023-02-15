package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.utils.TencentCosUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    @PostMapping("add-article")
    public AjaxJson addArticle(Long artTypeId,
                               String artTitle,
                               @RequestParam(value = "artContent",required = false) String artContent,
                               Long artUserId,
                               @RequestParam(value = "file",required = false) MultipartFile[] file) throws Exception {

        //写入文章
        Article article = new Article();
        article.setArtTypeId(artTypeId);
        article.setArtTitle(artTitle);
        article.setArtContent(artContent);
        article.setArtUserId(artUserId);
        String join = "";
        //是否上传图片判断
        if (file != null) {
            //图片URL
            ArrayList<String> arrayList = new ArrayList<>();
            for (MultipartFile multipartFile : file) {
                String uploadFiles = TencentCosUtil.uploadFile(multipartFile);
                arrayList.add(uploadFiles);
                join = StringUtils.join(arrayList, ",");
            }
        }
        article.setArtImage(join);
        articleService.addArticle(article);

        return AjaxJson.getSuccess();
    }
}
