package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ZoneService zoneService;
    @Autowired
    private ArticleService articleService;

    /**
     * 发帖
     * @param article
     * @return
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article){
        articleService.addArticle(article);
        return "redirect:/article/getArticleList.do";
    }

    /**
     * 根据zoneId查询帖子集合
     * @param zoneId
     * @return
     */
    @RequestMapping("/getArticleList")
    public ModelAndView getArticleListByZoneId(Integer zoneId){
        ModelAndView mv = new ModelAndView();
        List<Zone> zoneList = zoneService.getZoneList();
        List<Article> articleList = articleService.getArticleListByZoneId(zoneId);
        mv.addObject("zoneList",zoneList);
        mv.addObject("articleList",articleList);
        mv.setViewName("article-list");
        return mv;
    }

    /**
     * 根据articleId查询帖子信息
     * @param articleId
     * @return
     */
    @RequestMapping("/getArticle")
    public ModelAndView getArticleById(Integer articleId){
        ModelAndView mv = new ModelAndView();
        Article article = articleService.getArticleById(articleId);
        mv.addObject("article",article);
        mv.setViewName("getArticle");
        return mv;
    }

}
