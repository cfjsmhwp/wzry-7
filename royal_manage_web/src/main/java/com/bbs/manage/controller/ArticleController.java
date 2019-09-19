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
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") int page
    ) {

        List<Article> articleList = articleService.getArticleList(page);
        PageInfo pageInfo = new PageInfo(articleList);
        return SetModelAndView(pageInfo, articleList);

    }

    //展示所有信息
    @RequestMapping("addFindByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                   @RequestParam(name = "title", required = true, defaultValue = "") String title,
                                   @RequestParam(name = "senderName", required = true, defaultValue = "") String senderName) {

        List<Article> articleList = articleService.getArticleList(page, title, senderName);
        PageInfo pageInfo = new PageInfo(articleList);
        return SetModelAndView(pageInfo, articleList, title, senderName);

    }


    //置顶
    @RequestMapping("changeStatus.do")
    public ModelAndView changeStatus(@RequestParam(name = "id", required = true) String articleId,
                                     @RequestParam(name = "page", required = true) int pn,
                                     @RequestParam(name = "isTop", required = true) int isTop,
                                     @RequestParam(name = "senderName", required = true) String senderName,
                                     @RequestParam(name = "title", required = true, defaultValue = "") String title) {

        List<Article> articleList = articleService.changeStatus(articleId, senderName, pn, isTop,title);
        PageInfo pageInfo = new PageInfo(articleList);
        return SetModelAndView(pageInfo, articleList, title, senderName);
    }

    //屏蔽
    @RequestMapping("deleteArticle.do")
    public ModelAndView deleteArticle(@RequestParam(name = "id", required = true) String articleId,
                                      @RequestParam(name = "page", required = true) int pn,
                                      @RequestParam(name = "isTop", required = true) int isTop,
                                      @RequestParam(name = "articleStatus", required = true) int articleStatus,
                                      @RequestParam(name = "senderName", required = true) String senderName,
                                      @RequestParam(name = "title", required = true, defaultValue = "") String title
    ) {

        List<Article> articleList = articleService.deleteArticle(articleId, senderName, pn, articleStatus,title);
        PageInfo pageInfo = new PageInfo(articleList);
        return SetModelAndView(pageInfo, articleList, title, senderName);
    }


    //方法封装
    public ModelAndView SetModelAndView(PageInfo pageInfo, List<Article> articleList) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    //重载
    public ModelAndView SetModelAndView(PageInfo pageInfo, List<Article> articleList, String title, String senderName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", articleList);
        mv.addObject("title", title);
        mv.addObject("senderName", senderName);
        mv.setViewName("ArticlePage");
        return mv;
    }
}
