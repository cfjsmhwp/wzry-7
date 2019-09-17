package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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
    @Insert("insert into bbs_article_table (articleId,title,content,sendTime,senderName,isTop，replyCount，upvoteCount，browseCount，zoneId，isReport) values (#{aritcle.articleId},#{article.title},#{article.content},#{article.sendTime},#{article.sendTime},#{article.senderName},#{article.isTop},#{article.replyCount},#{article.upvoteCount},#{article.browseCount},#{article.zoneId},#{article.isReport})")
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
    @Select("select * from article where articleId = #{articleId}")
    @Results({
            @Result(property = "articleId",column = "articleId"),
            @Result(property = "title",column = "title"),
            @Result(property = "sendTime",column = "sendTime"),
            @Result(property = "senderName",column = "senderName"),
            @Result(property = "isTop",column = "isTop"),
            @Result(property = "isTop",column = "isTop"),
            @Result(property = "replyCount",column = "replyCount"),
            @Result(property = "upVoteCount",column = "upVoteCount"),
            @Result(property = "browseCount",column = "browseCount"),
            @Result(property = "zoneId",column = "zoneId"),
            @Result(property = "isReport",column = "isReport"),
            @Result(property = "commentList",column = "articleId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.getCommentList"))
    })
    Article getArticleById(Integer articleId);
}
