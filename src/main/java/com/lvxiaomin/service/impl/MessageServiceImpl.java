package com.lvxiaomin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvxiaomin.entity.Message;
import com.lvxiaomin.service.MessageService;
import com.lvxiaomin.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/** 留言板
* @author 75494
* @description 针对表【message】的数据库操作Service实现
* @createDate 2022-12-09 16:18:00
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




