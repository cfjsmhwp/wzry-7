package com.bbs.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {

    //查询所有回复
    @Select("select * from reply")
    List getReplyList();
}
