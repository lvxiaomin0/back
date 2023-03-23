package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/3/14 15:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectStatusVo {

    @NotNull(message = "could not null")
    @JsonProperty(value = "artId")
    int artId;

    @NotNull(message = "could not null")
    @JsonProperty(value = "userId")
    int userId;
}
