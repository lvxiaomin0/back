package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/3/28 10:44
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPwd {

    @NotEmpty(message = "Could Not Empty")
    @JsonProperty(value = "userEmail")
    private String userEmail;


    @NotEmpty(message = "Could Not Empty")
    @JsonProperty(value = "userPassword")
    private String userPassword;


}
