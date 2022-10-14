package com.lvxiaomin.mapper;

import com.lvxiaomin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Ming
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-08-07 15:34:38
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




