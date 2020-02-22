package org.ocoyue.jdbc.service.impl;

import org.ocoyue.jdbc.dao.ArticleJDBCDAO;
import org.ocoyue.jdbc.service.ArticleJDBDService;
import org.ocoyue.jdbc.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/14  上午10:15
 * @describe: TODO
 */


@Service
public class ArticleJDBCServiceImpl implements ArticleJDBDService {

    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;

    // jdbc 双数据源
    // @Resource
    // @Qualifier("primaryJdbcTemplate")
    // private JdbcTemplate jdbc1;
    //
    //
    // @Resource
    // @Qualifier("secondaryJdbcTemplate")
    // private JdbcTemplate jdbc2;



    // JTA
    @Resource
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbc1;


    @Resource
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbc2;


    @Transactional
    public Article saveArticle(Article article, Integer db) {

        // if (db == 2) {
        //     articleJDBCDAO.save(article, jdbc2);
        // } else {
        //     articleJDBCDAO.save(article, jdbc1);
        // }
        articleJDBCDAO.save(article,jdbc1);
        articleJDBCDAO.save(article,jdbc2);
        // int i = 2/0;
        return article;
    }

    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);

    }

    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);

    }

    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
