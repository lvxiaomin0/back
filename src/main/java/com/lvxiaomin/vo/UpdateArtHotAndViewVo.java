package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/3/10 14:13
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArtHotAndViewVo {

    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "artId")
    int artId;
}
