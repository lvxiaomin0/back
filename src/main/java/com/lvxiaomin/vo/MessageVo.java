package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/3/30 11:04
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageVo {
    /**
     * ID
     */
    @NotNull(message = "Could Not Null")
    @JsonProperty(value = "userId")
    private Long userId;

    /**
     * 内容
     */
    @NotEmpty(message = "Could Not Null")
    @JsonProperty(value = "mContent")
    private String mContent;

    /**
     * 用户昵称
     */
    @NotEmpty(message = "Could Not Null")
    @JsonProperty(value = "mNickname")
    private String mNickname;
}
