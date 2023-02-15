package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: Ming
 * @Date: 2023/01/10 16:10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto implements Serializable {


    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "artTypeId")
    private Long artTypeId; //文章类型

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "artTitle")
    private String artTitle;//文章标题

    @JsonProperty(value = "artContent")
    private String artContent;//文章内容

    @NotNull(message = "could not be NotNUll") //对数值进行校验时用NotNUll
    @JsonProperty(value = "artUserId")
    private Long artUserId; //用户id


    @JsonProperty(value = "artView")
    private Integer artView; //浏览量

    @JsonProperty(value = "artImage")
    private String artImage; //文章图片

    @JsonProperty(value = "artLikeNum")
    private Integer artLikeNum; //点赞量

    @JsonProperty(value = "artHotNum")
    private Integer artHotNum; //热度

    @JsonProperty(value = "artCommentId")
    private Long artCommentId; //评论id

    @JsonProperty(value = "artComNum")
    private Integer artComNum; //评论量
}
