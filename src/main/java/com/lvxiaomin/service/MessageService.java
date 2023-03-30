package com.lvxiaomin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lvxiaomin.entity.Message;
import com.lvxiaomin.vo.MessageVo;

/**
* @author Ming
* @description 针对表【message】的数据库操作Service
* @createDate 2022-12-09 16:18:00
*/
public interface MessageService extends IService<Message> {
        /**
         * 留言写入
         * @param messageVo
         * @return
         */
        String addMessage(MessageVo messageVo);

        /**
         * 分页查询留言
         * @param current
         * @param size
         * @return List
         */
        IPage<Message> getMessage(int current, int size);
}
