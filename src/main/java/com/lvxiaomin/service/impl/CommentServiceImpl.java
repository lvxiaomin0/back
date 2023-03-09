package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.dto.CommentDto;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.Comment;
import com.lvxiaomin.entity.User;
import com.lvxiaomin.mapper.ArticleMapper;
import com.lvxiaomin.mapper.CommentMapper;
import com.lvxiaomin.mapper.UserMapper;
import com.lvxiaomin.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/** 评论
* @author Ming
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-08-07 15:34:32
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;
    
    @Autowired
    private UserMapper userMapper;



    /**
     * 评论写入
     * @param commentDto commentDto
     * @return int
     */

    @Override
    public int insertComment(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto,comment);
        int insert = commentMapper.insert(comment);
        Long ArtId = commentDto.getComArtId();
        //查询对应文章id对应评论数量
        LambdaQueryWrapper<Comment> commentWrapper = new LambdaQueryWrapper<>();
        commentWrapper.eq(Comment::getComArtId,ArtId);
        int artCommetCount = Math.toIntExact(commentMapper.selectCount(commentWrapper));

        //更新文章评论量
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getArtId,ArtId);

        Article article = new Article();
        article.setArtComNum(artCommetCount);
        articleMapper.update(article,updateWrapper);
        return insert;

    }

    /**
     * 通过文章id 查询所有评论
     * @param artId artId
     * @return commentList
     */
    @Override
    public List<Comment> getAllCommentList(int artId) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getComArtId, artId);
        List<Comment> commentList = commentMapper.selectList(lambdaQueryWrapper);
        for (Comment comment : commentList) {
            User user = userMapper.selectById(comment.getComUserId());
            HashMap<String, User> map = new HashMap<>();
            user.setUserPassword(null);
            map.put("user",user);
            comment.setMap(map);
        }
        return commentList;
    }

}




