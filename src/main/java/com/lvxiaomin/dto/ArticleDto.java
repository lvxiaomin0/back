package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: Ming
 * @Date: 2022/11/1 16:10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto implements Serializable {
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "typeName")
    private String typeName; //文章类型

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "artTitle")
    private String artTitle;//文章标题

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "artContent")
    private String artContent;//文章内容

    @NotNull(message = "could not be empty") //对数值进行校验时用NotNUll
    @JsonProperty(value = "userId")
    private Long artUserId; //用户id
}
