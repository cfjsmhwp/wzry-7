package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;

import java.text.ParseException;
import java.util.List;

public interface ArticleService {
    //查询所有帖子
    List<Article> getArticleList();

    //发帖
    void addArticle(Article article);

    //根据zoneId查询帖子
    List<Article> getArticleListByZoneId(Integer zoneId);

    //根据articleId查询帖子信息
    Article getArticleById(Integer articleId);


    List<Article> findAll(Integer zoneId);



    Integer findArticleCountToday() throws ParseException;

    Integer findAllArticleCount();



    List<Article> findByCondition(String condition);
}
