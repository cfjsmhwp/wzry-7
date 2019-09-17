package com.bbs.controller;

import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.stream.events.Comment;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String Login(){

        return "";
    }

    /**
     * 发帖，添加帖子
     * @param comment
     * @return
     */
    @RequestMapping("/addPost")
    public String addPost(Comment comment){
        userService.addPost(comment);
        return "redirect:findAllPost.do";
    }

}
