package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    //查询所有评论
    @Select("select * from bbs_comment_table order by commentId asc")
    @Results({
            @Result(property = "commentId",column = "commentId"),
            @Result(property = "commentContent",column = "commentContent"),
            @Result(property = "commentTime",column = "commentTime"),
            @Result(property = "commentUserName",column = "commentUserName"),
            @Result(property = "commentStatus",column = "commentStatus"),
            @Result(property = "articleId",column = "articleId"),
            @Result(property = "replyList",column = "commentId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.ReplyDao.getRelyListByCommentId"))
    })
    List<Comment> getCommentList();

    //评论
    @Insert("insert into bbs_comment_table (commentContent,commentTime,commentUserName,commentStatus,articleId) values (#{commentContent},#{commentTime},#{commentUserName},#{commentStatus},#{articleId})")
    Comment addComment(Comment comment);
}
