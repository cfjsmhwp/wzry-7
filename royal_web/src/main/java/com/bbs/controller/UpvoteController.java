package com.bbs.controller;

import com.bbs.domain.Upvote;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    @RequestMapping("/addUpvote.do")
    public String addUpvote(Upvote upvote){
        ModelAndView mv = new ModelAndView();
        upvoteService.addUpvote(upvote);
        return "redirect:/article/getArticle.do";
    }
}
