package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneDao {

    //查询所有空间
    @Select("select * from bbs_zone_table")
    @Results({
            @Result(property = "zoneId",column = "zoneId"),
            @Result(property = "zoneName",column = "zoneName"),
            @Result(property = "articleList",column = "zoneId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.ArticleDao.getArticleListByZoneId"))
    })
    List<Zone> getZoneList();
}
