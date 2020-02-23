package org.ocoyue.jdbc.dao;

import lombok.extern.slf4j.Slf4j;
import org.ocoyue.jdbc.vo.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/14  上午9:46
 * @describe: TODO
 */
@Slf4j
@Repository
public class ArticleJDBCDAO {



    @Resource
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbc1;


    @Resource
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbc2;

    //保存文章
    public void save(Article article, JdbcTemplate jdbc) {
        log.info(jdbc.toString());

        log.info(LocalDateTime.now(ZoneId.systemDefault()).toString());
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbc.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                LocalDateTime.now(ZoneId.systemDefault())
        );

    }

    //删除文章
    public void deleteById(Long id) {
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbc1.update("DELETE FROM article WHERE id = ?",new Object[]{id});

    }

    //更新文章
    public void updateById(Article article) {
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbc1.update("UPDATE article SET author = ?, title = ? ,content = ?,create_time = ? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());

    }

    //根据id查找文章
    public Article findById(Long id) {
        //queryForObject用于查询单条记录返回结果
        return (Article) jdbc1.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(Article.class));
    }

    //查询所有
    public List<Article> findAll(){
        //query用于查询结果列表
        return (List<Article>) jdbc1.query("SELECT * FROM article ",  new BeanPropertyRowMapper(Article.class));
    }

    //保存文章到二库
    public void saveDB2(Article article) {
        log.info(jdbc2.toString());

        log.info(LocalDateTime.now(ZoneId.systemDefault()).toString());
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbc2.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                LocalDateTime.now(ZoneId.systemDefault())
        );

    }

}