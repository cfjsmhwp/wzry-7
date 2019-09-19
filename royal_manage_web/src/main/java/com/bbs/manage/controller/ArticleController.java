package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //展示所有信息
    @RequestMapping("findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.getArticleList(page);
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;

    }

    //置顶
    @RequestMapping("changeStatus.do")
    public ModelAndView changeStatus(@RequestParam(name = "id", required = true) String articleId,
                                     @RequestParam(name = "pn", required = true) int pn,
                                     @RequestParam(name = "isTop", required = true) int isTop,
                                     @RequestParam(name = "senderName", required = true) String senderName) {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.changeStatus(articleId, senderName, pn, isTop);
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    //屏蔽
    @RequestMapping("deleteArticle.do")
    public ModelAndView deleteArticle(@RequestParam(name = "id", required = true) String articleId,
                                      @RequestParam(name = "pn", required = true) int pn,
                                      @RequestParam(name = "isTop", required = true) int isTop,
                                      @RequestParam(name = "articleStatus", required = true) int articleStatus,
                                      @RequestParam(name = "senderName", required = true) String senderName
    ) {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.deleteArticle(articleId, senderName, pn, articleStatus);
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;

    }

    //模糊查询
    @RequestMapping("fuzzyQuery.do")
    public ModelAndView fuzzyQuery(@RequestParam(name = "title") String title,
                                   @RequestParam(name = "senderName") String senderName,
                                   @RequestParam(name = "pn", required = true,defaultValue = "1") int pn

    ) {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.fuzzyQuery(title, senderName, pn);
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.addObject("title", title);
        mv.addObject("senderName", senderName);

        mv.setViewName("ArticlePage");
        return mv;
    }

}
