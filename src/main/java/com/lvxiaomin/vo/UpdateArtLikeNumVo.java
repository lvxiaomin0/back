package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/3/13 11:24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArtLikeNumVo {

    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "artId")
    int artId;

    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "userId")
    int userId;
}
