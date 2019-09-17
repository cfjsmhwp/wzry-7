package com.bbs.controller;

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
     * 查询所有回复
     * @return
     */
    @RequestMapping("/getReplyList")
    public ModelAndView getReplyList(){
        ModelAndView mv = new ModelAndView();
        List replyList = replyService.getReplyList();
        mv.addObject("replyList",replyList);
        mv.setViewName("reply-list");
        return mv;
    }

}
