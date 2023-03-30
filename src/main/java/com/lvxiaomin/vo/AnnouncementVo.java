package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/3/30 20:03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementVo {

    /**
     * 流动消息内容
     */
    @NotEmpty(message = "Could Not Empty")
    @JsonProperty(value = "moContent")
    private String moContent;
}
