package com.lvxiaomin.controller.services;

import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.utils.TencentCosUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/** 腾讯云存储测试
 * @Author: Ming
 * @Date: 2023/2/3 15:25
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class TencentUploadController {

    @Autowired
    private ArticleService articleService;



    @PostMapping("/updateFile")
    public AjaxJson uploadFile(@RequestParam("file") MultipartFile[] file) throws Exception {

        List<MultipartFile> multipartFiles = Arrays.asList(file);
        for (int i = 0; i < multipartFiles.size(); i++) {
            String uploadFiles = TencentCosUtil.uploadFile(multipartFiles.get(i));
            //需要写入imgurl
//            articleImageService.addArticleImage(uploadFiles);

        }
//        articleService.addArticleImageId(null);
        return AjaxJson.getSuccess();

    }
}
