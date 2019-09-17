package org.ocoyue.jdbc.service;


import org.ocoyue.jdbc.vo.Article;

import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/14  上午10:13
 * @describe: TODO
 */
public interface ArticleJDBDService {

    public Article saveArticle(Article article, Integer db);

    public void deleteArticle(Long id);

    public void updateArticle(Article article);

    public Article getArticle(Long id);

    public List<Article> getAll();
}