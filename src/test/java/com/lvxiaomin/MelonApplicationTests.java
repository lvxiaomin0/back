package com.lvxiaomin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lvxiaomin.dto.ArticleDto;
import com.lvxiaomin.entity.Article;
import com.lvxiaomin.entity.ArticleImage;
import com.lvxiaomin.mapper.ArticleImageMapper;
import com.lvxiaomin.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelonApplicationTests {
    @Autowired
    ArticleImageMapper articleImageMapper;

    @Test
    void contextLoads() {


    }
}
