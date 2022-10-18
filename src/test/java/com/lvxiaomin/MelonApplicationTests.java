package com.lvxiaomin;

import com.lvxiaomin.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelonApplicationTests {
    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
    articleService.getArticle().forEach(System.out::println);

    }
}
