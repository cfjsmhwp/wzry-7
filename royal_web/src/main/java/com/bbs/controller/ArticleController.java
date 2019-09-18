package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 查询某人发帖数
     * @param response
     * @param senderName
     * @throws Exception
     */
    @RequestMapping("/getTotalCount")
    public void  getTotalCount(HttpServletResponse response, @RequestParam("userName")String senderName)throws Exception{
        int count = articleService.getTotalCount(senderName);
        System.out.println(count);
        response.getWriter().print(count);
    }

}
