package org.ocoyue.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ocoyue.jdbc.dao.ArticleJDBCDAO;
import org.ocoyue.jdbc.vo.Article;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: Zoé
 * @date: 2019/9/16  下午9:38
 * @describe: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJDBCTest {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;


    @Test
    public void testJdbc() {
        articleJDBCDAO.save(Article.builder().author("zimug").title("primaryJdbcTemplate").content("ceshi").createTime(new Date()).build(),
                primaryJdbcTemplate);
        articleJDBCDAO.save(Article.builder().author("zimug").title("secondaryJdbcTemplate").content("ceshi").createTime(new Date()).build(),
                secondaryJdbcTemplate);
    }


}