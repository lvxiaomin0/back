package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.service.CommentService;
import com.lvxiaomin.entity.Comment;
import com.lvxiaomin.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Ming
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-08-07 15:34:32
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




