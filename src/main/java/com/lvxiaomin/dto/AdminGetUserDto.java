package com.lvxiaomin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Ming
 * @Date: 2023/3/23 22:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminGetUserDto {

    private Integer userId;

    /**
     *
     */
    private String userBlog;

    /**
     *
     */
    private Integer userConcern;

    /**
     *
     */
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

    private String userTime;
}
