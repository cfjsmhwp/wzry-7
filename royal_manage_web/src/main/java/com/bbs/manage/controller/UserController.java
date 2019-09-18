package com.bbs.manage.controller;

import com.bbs.domain.UserInfo;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findByPage();
        mv.setViewName("user");
        mv.addObject("userList",userList);
        return mv;
    }
}
