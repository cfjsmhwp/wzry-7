package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IArticleDao {

    @Select("select * from bbs_article_table where zoneId = #{zoneId} order by isTop desc")
    List<Article> findAll(Integer zoneId);

    @Select("select count(userId) from bbs_user_table where loginStatus = 1")
    Integer findOnlineUserCount();

    @Select("select userName from bbs_user_table where loginStatus = 1")
    String[] findOnlineUserName();

    @Select("select count(articleId) from bbs_article_table where sendTime > #{date}")
    Integer findArticleCountToday(Date date);

    @Select("select count(articleId) from bbs_article_table")
    Integer findAllArticleCount();

    @Select("select * from bbs_zone_table")
    List<Zone> findAllZone();

    @Select("select * from bbs_article_table where title like #{condition} or content like #{condition}")
    List<Article> findByCondition(String condition);
}
