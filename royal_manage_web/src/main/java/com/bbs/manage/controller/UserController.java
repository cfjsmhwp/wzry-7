package com.bbs.manage.controller;

import com.bbs.domain.UserInfo;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findByPage(page,size);
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-page");
        return mv;
    }
}
