package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.UserDao;
import com.bbs.dao.ZoneDao;
import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ZoneDao zoneDao;

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
    public List<Article> findAll(Integer zoneId) {
        return articleDao.findAll(zoneId);
    }


    @Override
    public Integer findArticleCountToday() throws ParseException {

        String time = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        Date today = DateUtils.string2Date(time, "yyyy-MM-dd");
        return articleDao.findArticleCountToday(today);
    }

    @Override
    public Integer findAllArticleCount() {
        return articleDao.findAllArticleCount();
    }



    @Override
    public List<Article> findByCondition(String condition) {
        condition = condition.trim();
        return articleDao.findByCondition("%"+condition+"%");
    }


    @Override
    public int getTotalCount(String senderName) {
        int count = articleDao.getTotalCount(senderName);
        return count;
    }
}
