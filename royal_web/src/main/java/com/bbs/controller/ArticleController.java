package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atricle")
public class ArticleController {

    @RequestMapping("/getArticleList.do")
    public String getArticleList() {
        return "";
    }

}


