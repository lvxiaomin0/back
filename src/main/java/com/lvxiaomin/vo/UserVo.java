package com.lvxiaomin.vo;

import com.lvxiaomin.entity.User;
import lombok.Data;

import java.util.Map;

/**
 * @Author: Ming
 * @Date: 2022/10/13 21:26
 */
@Data
public class UserVo extends User{
    User user;
    Map<String,Object> userMap;
}
