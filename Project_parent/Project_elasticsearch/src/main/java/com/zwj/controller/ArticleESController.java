package com.zwj.controller;


import com.zwj.base.PageResult;
import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.entity.Article;
import com.zwj.service.ArticleESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articlees")
public class ArticleESController {
    @Autowired
    private ArticleESService articleESService ;

    @PostMapping
    public Result addArticle(@RequestBody Article article){
        articleESService.saveArticle(article);
        return new Result(true, StatusCode.OK,"存入引擎成功") ;
    }

    @GetMapping("{keywords}/{start}/{pageSize}")
    public Result addArticle(@PathVariable String keywords,@PathVariable int page,@PathVariable("pageSize") int ps){
        Page<Article> articlePage = articleESService.findByTitleOrDescriptionLike(keywords, page, ps);
        return new Result(true, StatusCode.OK,"存入引擎成功" ,  new PageResult<Article>(articlePage.getTotalElements(),articlePage.getContent()  )) ;
    }





}
