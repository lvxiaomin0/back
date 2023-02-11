package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleImageService;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.utils.TencentCosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/** 腾讯云存储
 * @Author: Ming
 * @Date: 2023/2/3 15:25
 */
@RestController
@RequestMapping("/upload")
public class TencentUploadController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleImageService articleImageService;

    @PostMapping("/updateFile")
    public AjaxJson uploadFile(@RequestBody @RequestParam("file") MultipartFile[] file) throws Exception {
        for (int i = 0; i < file.length; i++) {
            String uploadFiles = TencentCosUtil.uploadFile(file[i]);
            //需要写入imgurl,id
            articleImageService.addArticleImage(uploadFiles);

        }
//        articleService.addArticleImageId(null);
        return AjaxJson.getSuccess();

    }
}
