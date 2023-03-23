package com.lvxiaomin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 数据库自动填充时间
 * @Author: Ming
 * @Date: 2023/2/13 1:20
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);

        this.setFieldValByName("artCreTime", format,metaObject);
        this.setFieldValByName("comTime", format,metaObject);
        this.setFieldValByName("comMultiTime", format,metaObject);
        this.setFieldValByName("userTime", format,metaObject);
        this.setFieldValByName("mTime", format,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(),metaObject);
    }
}
