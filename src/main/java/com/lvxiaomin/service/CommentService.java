package com.lvxiaomin.service;

import com.lvxiaomin.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Ming
* @description 针对表【comment】的数据库操作Service
* @createDate 2022-08-07 15:34:32
*/
public interface CommentService extends IService<Comment> {

    int insertComment(Comment comment);

}
