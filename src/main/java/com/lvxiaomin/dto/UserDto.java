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
    private String userBlog;

    /**
     *
     */
    private Integer userConcern;

    /**
     *
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "userEmail")
    private String userEmail;

    /**
     *
     */
    private Integer userFans;

    /**
     *
     */
    private String userImg;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "userPassword")
    private String userPassword;

    /**
     *
     */
    private String userPhone;

    /**
     *
     */
    private String userSex;

    /**
     *
     */
    private String userShow;

    /**
     *
     */
    private Integer userStatus;

    /**
     *
     */
    private Date userTime;

}
