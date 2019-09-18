package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleDao {

    /**
     * 查询所有帖子
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> getArticleList();

    /**
     * 发帖
     * @param article
     */
    @Insert("insert into bbs_article_table (title,content,sendTime,senderName,isTop，replyCount，upvoteCount，browseCount，zoneId，isReport) values (#{article.title},#{article.content},#{article.sendTime},#{article.sendTime},#{article.senderName},#{article.isTop},#{article.replyCount},#{article.upvoteCount},#{article.browseCount},#{article.zoneId},#{article.isReport})")
    void addArticle(Article article);

    /**
     * 根据zoneId查询帖子
     * @return
     */
    @Select("select * from bbs_article_table where zoneId = #{zoneId}")
    List<Article> getArticleListByZoneId(Integer zoneId);

    /**
     * 根据articleId查询帖子信息
     * @param articleId
     * @return
     */
    @Select("select * from bbs_article_table where articleId = #{articleId}")
    @Results({
            @Result(property = "articleId",column = "articleId"),
            @Result(property = "title",column = "title"),
            @Result(property = "sendTime",column = "sendTime"),
            @Result(property = "senderName",column = "senderName"),
            @Result(property = "isTop",column = "isTop"),
            @Result(property = "isTop",column = "isTop"),
            @Result(property = "replyCount",column = "replyCount"),
            @Result(property = "upvoteCount",column = "upvoteCount"),
            @Result(property = "browseCount",column = "browseCount"),
            @Result(property = "zoneId",column = "zoneId"),
            @Result(property = "isReport",column = "isReport"),
            @Result(property = "commentList",column = "articleId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.getCommentList"))
    })
    Article getArticleById(Integer articleId);

    /**
     * 根据交流区查询主页所有列表
     * @param zoneId
     * @return
     */
    @Select("select * from bbs_article_table where zoneId = #{zoneId} order by isTop desc")
    List<Article> findAll(Integer zoneId);


    /**
     * 查询今日帖子数
     * @param date
     * @return
     */
    @Select("select count(articleId) from bbs_article_table where sendTime > #{date}")
    Integer findArticleCountToday(Date date);

    /**
     * 查询所有帖子数
     * @return
     */
    @Select("select count(articleId) from bbs_article_table")
    Integer findAllArticleCount();



    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    @Select("select * from bbs_article_table where title like #{condition} or content like #{condition}")
    List<Article> findByCondition(String condition);

    @Select("select count(*) from bbs_article_table where senderName = #{senderName}")
    int getTotalCount(String senderName);
}
