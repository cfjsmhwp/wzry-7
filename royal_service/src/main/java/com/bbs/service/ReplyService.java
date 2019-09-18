package com.bbs.service;

import com.bbs.domain.Reply;

import java.util.List;

public interface ReplyService {

    //根据commentId查询所有回复
    List<Reply> getReplyListByCommentId(Integer commentId);

    //回复
    void addReply(Reply reply);



}
