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
            @Result(property = "articleList",column = "zoneId",javaType = List.class,
                    many = @Many(select = "com.bbs.dao.ArticleDao.getArticleListByZoneId"))
    })
    List<Zone> getZoneList();

    /**
     * 查询所有交流区
     * @return
     */
    @Select("select * from bbs_zone_table")
    List<Zone> findAllZone();

    /**
     * 开辟新板块申请
     * @param userName
     * @param zoneName
     * @param reason
     * @return
     */
    @Insert("insert into bbs_zoneapply_table (userName,zoneName,reason) values(#{userName},#{zoneName},#{reason})")
    int save(@Param("userName") String userName, @Param("zoneName")String zoneName, @Param("reason")String reason);

    /**
     * 添加板块
     * @param zoneName
     * @throws Exception
     */
    @Insert("insert into bbs_zone_table (zoneName,isDef) values (#{zoneName},#{isDef})")
    void addZone(@Param("zoneName") String zoneName,@Param("isDef") Integer isDef) throws Exception;
}
