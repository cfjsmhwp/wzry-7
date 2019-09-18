package com.bbs.dao;

import com.bbs.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select * from bbs_user_table where  userName = #{userName}")
    UserInfo findByUsername(String userName);

    @Select("select * from bbs_user_table")
    List<UserInfo> findByPage();
}
