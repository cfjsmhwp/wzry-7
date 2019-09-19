package com.bbs.manage.controller;



import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    //展示所有信息
    @RequestMapping("findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView();
        List<Report> reportList=reportService.getReportList(page);
        PageInfo pageInfo = new PageInfo(reportList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("reportList",reportList);

        mv.setViewName("reportPage");
       return mv;
    }

    //屏蔽
    @RequestMapping("deleteArticle.do")
    public ModelAndView deleteArticle(@RequestParam(name = "id", required = true) String articleId,
                                      @RequestParam(name = "pn", required = true) int pn,
                                      @RequestParam(name = "articleStatus", required = true,defaultValue = "") int articleStatus

    ) {
        ModelAndView mv = new ModelAndView();
        List<Report> reportList = reportService.deleteArticle(articleId, pn, articleStatus);
        PageInfo pageInfo = new PageInfo(reportList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("articleList", reportList);
        mv.setViewName("reportPage");
        return mv;

    }
}
