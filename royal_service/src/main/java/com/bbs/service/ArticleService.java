package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.github.pagehelper.PageHelper;

import java.text.ParseException;
import java.util.List;

public interface ArticleService {
    //查询所有帖子
    List<Article> getArticleList(int page);
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

    int getTotalCount(String senderName);
    //置顶条件
    List<Article> changeStatus(String articleId, String senderName,int pn,int isTop);
    //屏蔽
    List<Article> deleteArticle(String articleId, String senderName, int pn, int articleStatus);

    //模糊查询
    List<Article> fuzzyQuery(String title, String senderName, int pn);
}
