package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/3/21 10:04
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    /**
     *用户昵称
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userName")
    private String userName;

    /**
     *用户个性签名
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userShow")
    private String userShow;

    /**
     *用户手机
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userPhone")
    private String userPhone;

    /**
     *用户性别
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userSex")
    private String userSex;

    /**
     *用户邮箱
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userEmail")
    private String userEmail;


    /**
     *用户密码
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "userPassword")
    private String userPassword;
}
