package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: Ming
 * @Date: 2023/3/1 20:48
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeUpdatePwdVo implements Serializable {

    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "userEmail")
    String userEmail;

    @NotNull(message = "could not be NotNUll")
    @JsonProperty(value = "securityCode")
    String securityCode;
}
