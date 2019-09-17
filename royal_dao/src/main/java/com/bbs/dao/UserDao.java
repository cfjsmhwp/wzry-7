package com.bbs.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into commment () values ()")
    void addPost();
}
