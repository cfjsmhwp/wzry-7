package com.bbs.controller;

import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    /**
     * 根据commentId查询所有回复
     * @return
     */
    @RequestMapping("/getReplyList.do")
    public ModelAndView getReplyListByCommentId(Integer commentId){
        ModelAndView mv = new ModelAndView();
        List<Reply> replyList = replyService.getReplyListByCommentId(commentId);
        mv.addObject("replyList",replyList);
        mv.setViewName("getArticle");
        return mv;
    }

    /**
     *
     */
    @RequestMapping("/addReply.do")
    public String addReply(Reply reply){
        replyService.addReply(reply);
        return "redirect:/article/getArticle";
    }

}
