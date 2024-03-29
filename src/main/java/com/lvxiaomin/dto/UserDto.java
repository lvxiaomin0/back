package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
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
