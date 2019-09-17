package com.bbs.service;

import com.bbs.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CommentService {

    //查询所有评论
    List<Comment> getCommentList();
}
