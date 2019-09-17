package com.bbs.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into commment () values ()")
    void addPost();

    /**
     * 查询在线用户名称
     * @return
     */
    @Select("select userName from bbs_user_table where loginStatus = 1")
    String[] findOnlineUserName();


    /**
     * 查询在线用户数
     * @return
     */
    @Select("select count(userId) from bbs_user_table where loginStatus = 1")
    Integer findOnlineUserCount();


}
