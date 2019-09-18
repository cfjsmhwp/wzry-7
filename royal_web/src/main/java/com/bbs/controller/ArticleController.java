package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.UserService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ZoneService zoneService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView getArticleList(
            @RequestParam(name = "condition", required = false, defaultValue = "") String condition,
            @RequestParam(name = "zoneId", required = false) Integer zoneId) throws ParseException {
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
        Integer onlineUserCount = userService.findOnlineUserCount();
        //查询所有在线用户名称
        String[] onlineUserNames = userService.findOnlineUserName();
        //查询今日帖子数
        Integer articleCountToday = articleService.findArticleCountToday();
        //查询所有帖子数
        Integer allArticleCount = articleService.findAllArticleCount();
        //查询所有交流区
        List<Zone> zoneList = zoneService.findAllZone();
        mv.addObject("zoneId", zoneId);
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
     *
     * @param
     * @return
     */
    @RequestMapping("/addArticle.do")
    public String addArticle(String content, String zoneId, String senderName,String title) {
        Article article = new Article();
        try {
            article.setTitle(title);
            article.setContent(content);
            article.setIsTop(0);
            article.setSenderName("老李");
            article.setBrowseCount(0);
            article.setReplyCount(0);
            article.setSendTime(new Date());
            article.setUpvoteCount(0);
            article.setIsReport(0);
            article.setZoneId(Integer.parseInt(zoneId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        articleService.addArticle(article);
        return "redirect:/article/findAll.do?zoneId="+ Integer.parseInt(zoneId);
    }


    /**
     * 根据zoneId查询帖子集合
     *
     * @param zoneId
     * @return
     */
    @RequestMapping("/getArticleList.do")
    public ModelAndView getArticleListByZoneId(Integer zoneId) {
        ModelAndView mv = new ModelAndView();
        List<Zone> zoneList = zoneService.getZoneList();
        List<Article> articleList = articleService.getArticleListByZoneId(zoneId);
        mv.addObject("zoneList", zoneList);
        mv.addObject("articleList", articleList);
        mv.setViewName("article-list");
        return mv;
    }

    /**
     * 根据articleId查询帖子信息
     *
     * @param articleId
     * @return
     */
    @RequestMapping("/getArticle.do")
    public ModelAndView getArticleById(Integer articleId) {
        ModelAndView mv = new ModelAndView();
        Article article = articleService.getArticleById(articleId);
        mv.addObject("article", article);
        mv.setViewName("getArticle");
        return mv;
    }

}
