package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询所有帖子
     * @return
     */
    @Override
    public List<Article> getArticleList() {
        return articleDao.getArticleList();
    }

    /**
     * 发帖
     * @param article
     *
     */
    @Override
    public void addArticle(Article article) {
        articleDao.addArticle(article);

    }

    /**
     * 根据zoneId查询帖子
     * @param zoneId
     * @return
     */
    @Override
    public List<Article> getArticleListByZoneId(Integer zoneId) {
        return articleDao.getArticleListByZoneId(zoneId);
    }

    /**
     * 根据articleId查询帖子信息
     * @param articleId
     * @return
     */
    @Override
    public Article getArticleById(Integer articleId) {
        return articleDao.getArticleById(articleId);
    }

    @Override
    public int getTotalCount(String senderName) {
        int count = articleDao.getTotalCount(senderName);
        return count;
    }
}
