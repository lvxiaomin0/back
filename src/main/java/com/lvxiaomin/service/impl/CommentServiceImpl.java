package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.service.CommentService;
import com.lvxiaomin.entity.Comment;
import com.lvxiaomin.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 评论
* @author Ming
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-08-07 15:34:32
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    //读取评论及其二级评论  List<Comment>



    /**
     * 评论写入
     * @param comment comment
     * @return int
     */
    @Transactional
    @Override
    public int insertComment(Comment comment) {

        return commentMapper.insert(comment);

    }

}




