package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Message;
import com.lvxiaomin.mapper.MessageMapper;
import com.lvxiaomin.service.MessageService;
import com.lvxiaomin.vo.MessageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/** 留言板
* @author Ming
* @description 针对表【message】的数据库操作Service实现
* @createDate 2022-12-09 16:18:00
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    /**
     * 留言写入
     * @param messageVo
     * @return
     */
    @Override
    public String addMessage(MessageVo messageVo) {
        Message message = new Message();
        BeanUtils.copyProperties(messageVo,message);
        int insert = messageMapper.insert(message);
        if (insert == 1) {
            return "留言成功！";
        }
        return "出现未知错误！！！";
    }

    /**
     * 留言分页返回
     * @param current
     * @param size
     * @return messageList
     */
    @Override
    public IPage<Message> getMessage(int current,int size) {
        IPage<Message> messagePage = new Page<>(current,size);
        IPage<Message> selectPage = messageMapper.selectPage(messagePage, null);
        return selectPage;
    }


}




