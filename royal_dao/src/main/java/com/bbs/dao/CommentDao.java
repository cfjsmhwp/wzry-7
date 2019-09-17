package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    //查询所有评论
    @Select("select * from bbs_comment_table")
    List<Comment> getCommentList();
}
