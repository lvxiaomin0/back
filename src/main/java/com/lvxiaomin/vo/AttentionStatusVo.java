package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/3/14 15:50
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttentionStatusVo {

    @NotNull(message = "could not null")
    @JsonProperty(value = "attAuthorId")
    private Long attAuthorId;


    @NotNull(message = "could not null")
    @JsonProperty(value = "attUserId")
    private Long attUserId;
}
