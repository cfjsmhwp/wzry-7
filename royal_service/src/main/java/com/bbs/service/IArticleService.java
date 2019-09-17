package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;

import java.text.ParseException;
import java.util.List;

public interface IArticleService {

    List<Article> findAll(Integer zoneId);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();

    Integer findArticleCountToday() throws ParseException;

    Integer findAllArticleCount();

    List<Zone> findAllZone();

    List<Article> findByCondition(String condition);
}
