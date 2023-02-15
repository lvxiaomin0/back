package com.lvxiaomin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/** 数据库自动填充时间
 * @Author: Ming
 * @Date: 2023/2/13 1:20
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("artCreTime", new Date(),metaObject);
        this.setFieldValByName("comTime", new Date(),metaObject);
        this.setFieldValByName("comMultiTime", new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(),metaObject);
    }
}
