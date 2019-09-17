package com.bbs.dao;

import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {

    /*//查询所有回复
    @Select("select * from reply")
    List getReplyList();*/

    //回复
    @Insert("insert into reply (replyContent,replyTime,replyUserName,commentId) values (#{replyContent},#{replyTime},#{replyUserName},#{commentId})")
    void addReply(Reply reply);

    //查询所有的回复
    @Select("select * from reply where commentId = #{commentId} order by replyId asc")
    List<Reply> getReplyListByCommentId(Integer commentId);

}
