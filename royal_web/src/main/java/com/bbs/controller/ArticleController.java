package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.IArticleService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/atricle")
public class ArticleController {

    @Autowired
    private ZoneService zoneService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll.do")
    public ModelAndView getArticleList(
                                       @RequestParam(name = "condition",required = false,defaultValue = "") String condition,
                                       @RequestParam(name = "zoneId",required = false)Integer zoneId) throws ParseException {
        ModelAndView mv = new ModelAndView();
        if (zoneId == null) {
            zoneId = 1;
        }
        List<Article> list;
        if (condition != null && condition.length() > 0) {
            //根据条件查询
            list = articleService.findByCondition(condition);
        } else {
            //查询综合交流区所有帖子
            list = articleService.findAll(zoneId);
        }

        //查询所有在线用户数
        Integer onlineUserCount = articleService.findOnlineUserCount();
        //查询所有在线用户名称
        String[] onlineUserNames = articleService.findOnlineUserName();
        //查询今日帖子数
        Integer articleCountToday = articleService.findArticleCountToday();
        //查询所有帖子数
        Integer allArticleCount = articleService.findAllArticleCount();
        //查询所有交流区
        List<Zone> zoneList = articleService.findAllZone();
        mv.addObject("zoneList", zoneList);
        mv.addObject("allArticleCount", allArticleCount);
        mv.addObject("onlineUserCount", onlineUserCount);
        mv.addObject("onlineUserNames", onlineUserNames);
        mv.addObject("articleCountToday", articleCountToday);
        mv.addObject("articleList", list);
        mv.setViewName("main");
        return mv;
    }

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
