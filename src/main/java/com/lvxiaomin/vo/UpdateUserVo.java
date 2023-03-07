package com.lvxiaomin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/3/6 9:53
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserVo {

    @NotEmpty(message = "userId could not empty")
    int userId;

    String userEmail;

    String userName;

    String userSex;

    String userShow;

    String userBlog;

    String userPhone;

    String userImg;

}
