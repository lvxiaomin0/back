package com.lvxiaomin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.UpdateArtLikeNumVo;

import java.util.List;
import java.util.Map;

/**
* @author Ming
* @description 针对表【article】的数据库操作Service
* @createDate 2022-08-07 15:34:13
*/
public interface ArticleService extends IService<Article> {

    /**
     * 获取用户及其帖子
     * @return List
     */
    List<Article> getArticle();

    /**
     * 写入文章
     * @param article article
     * @return null
     */
    Map<String,Article> addArticle(Article article);


    /**
     * 获取寻物文章类型
     * @param id artTypeId
     * @return List
     */
    List<Article> getArticleById(int id);

    /**
     * 文章热度增加
     * @param artId
     * @return
     */
    AjaxJson updateArtHotAndArtView(int artId);

    /**
     * 用户喜欢文章量
     * @param updateArtLikeNumVo updateArtLikeNumVo
     * @return
     */
    AjaxJson updateArtLikeNum(UpdateArtLikeNumVo updateArtLikeNumVo);

}
