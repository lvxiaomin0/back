package com.lvxiaomin.controller.services;

import com.lvxiaomin.dto.CommentDto;
import com.lvxiaomin.entity.Comment;
import com.lvxiaomin.service.CommentService;
import com.lvxiaomin.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**用户评论
 * @Author: Ming
 * @Date: 2023/2/14 14:46
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;


    /**
     * 评论写入
     * @param commentDto commentDto
     * @return AjaxJson
     */
    @PostMapping("/set-comments")
    public AjaxJson setComments(@RequestBody CommentDto commentDto){
        int insertComment = commentService.insertComment(commentDto);
        return AjaxJson.getSuccess(String.valueOf(insertComment));
    }

    /**
     * 获取评论
     * @param id
     * @return
     */
    @GetMapping("/get-comments")
    public AjaxJson getCommentsById(@RequestParam("artId") int id){
        List<Comment> allCommentList = commentService.getAllCommentList(id);
        return AjaxJson.getSuccessData(allCommentList);
    }
}
