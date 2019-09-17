package org.ocoyue.jdbc.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.ocoyue.jdbc.service.ArticleJDBDService;
import org.ocoyue.jdbc.vo.AjaxResponse;
import org.ocoyue.jdbc.vo.Article;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/14  上午10:32
 * @describe: TODO
 */

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    ArticleJDBDService articleJDBDService;


    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response= AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    @PostMapping("/jdbc/{db}")
    public AjaxResponse jdbcSaveArticle(@RequestBody Article article, @PathVariable Integer db) {

        log.info("saveArticle：{}",article);

        log.info("articleRestService return :" + articleJDBDService.saveArticle(article,db));

        return  AjaxResponse.success(article);
    }

    @DeleteMapping("/jdbc/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}",id);

        return AjaxResponse.success(id);
    }

    @PutMapping("/jdbc/{db}")
    public AjaxResponse updateArticle(@RequestBody Article article, @PathVariable Integer db) {

        article = articleJDBDService.saveArticle(article,db);

        log.info("updateArticle：{}",article);

        return AjaxResponse.success(article);
    }

    @GetMapping( "/jdbc/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1L).author("a1").content("c1").title("t1").build();
        return AjaxResponse.success(article1);
    }

    @GetMapping("/jdbc/all")
    public AjaxResponse getAll() {
        List<Article> list = articleJDBDService.getAll();
        return AjaxResponse.success(list);
    }
}


