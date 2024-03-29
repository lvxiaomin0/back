package com.lvxiaomin.mapper;

import com.lvxiaomin.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 75494
* @description 针对表【message】的数据库操作Mapper
* @createDate 2022-12-09 16:18:00
* @Entity com.lvxiaomin.entity.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}




