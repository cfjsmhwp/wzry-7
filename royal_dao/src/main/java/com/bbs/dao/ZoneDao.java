package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.*;
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

    @Insert("insert into bbs_zoneapply_table (userName,zoneName,reason) values(#{userName},#{zoneName},#{reason})")
    int save(@Param("userName") String userName, @Param("zoneName")String zoneName, @Param("reason")String reason);

}
