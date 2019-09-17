package com.bbs.controller;

import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询所有评论
     * @return
     */
    @RequestMapping("/getCommentList")
    public ModelAndView getCommentList(){
        ModelAndView mv = new ModelAndView();
        List<Comment> commentList = commentService.getCommentList();
        mv.addObject("commentList",commentList);
        mv.setViewName("");
        return mv;
    }
}
