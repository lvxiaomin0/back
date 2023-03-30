package com.lvxiaomin.controller.services;

import com.lvxiaomin.entity.Article;
import com.lvxiaomin.service.ArticleService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.utils.TencentCosUtil;
import com.lvxiaomin.vo.GetArticleByIdVo;
import com.lvxiaomin.vo.UpdateArtHotAndViewVo;
import com.lvxiaomin.vo.UpdateArtLikeNumVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**文章
 * @Author: Ming
 * @Date: 2022/10/17 10:02
 */
@RestController
@RequestMapping("/service")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("get-article")
    public AjaxJson getArticle(){
        List<Article> articleList = articleService.getArticle();

        return AjaxJson.getSuccessData(articleList);
    }

    /**
     * 添加文章
     * @param artTypeId artTypeId
     * @param artTitle artTitle
     * @param artContent artContent
     * @param artUserId artUserId
     * @param file file
     * @return AjaxJson
     * @throws Exception fileException
     */
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

    /**
     * 获取寻物文章
     * @param getArticleByIdVo artId
     * @return List
     */
    @GetMapping("/get-particle")
    public AjaxJson getArticleById(GetArticleByIdVo getArticleByIdVo){
        List<Article> articleById = articleService.getArticleById(getArticleByIdVo.getArtTypeId());
        return AjaxJson.getSuccessData(articleById);
    }

    /**
     * 更新文章热度及文章访问量
     * @param updateArtHotAndViewVo artID
     * @return AjaxJson
     */
    @PostMapping("/update-arthrotomies")
    public AjaxJson updateArtHotAndView(@RequestBody UpdateArtHotAndViewVo updateArtHotAndViewVo){
        AjaxJson ajaxJson = articleService.updateArtHotAndArtView(updateArtHotAndViewVo.getArtId());
        return AjaxJson.getSuccess();
    }


    /**
     * 更新文章喜欢数量
     * @param
     * @return AjaxJson
     */
    @GetMapping("/update-artLikeNum")
    public AjaxJson updateArtLikeNum( UpdateArtLikeNumVo updateArtLikeNumVo){
        AjaxJson ajaxJson = articleService.updateArtLikeNum(updateArtLikeNumVo);
        return AjaxJson.getSuccessData(ajaxJson);
    }
}
