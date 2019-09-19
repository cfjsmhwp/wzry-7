package com.bbs.manage.controller;

import com.bbs.domain.ZoneApply;
import com.bbs.service.ZoneApplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneApply")
public class ZoneApplyController {

    @Autowired
    private ZoneApplyService zoneApplyService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "4")Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<ZoneApply> zoneApplyList = zoneApplyService.findAllZoneApply(pageNum,pageSize);

        PageInfo pageInfo = new PageInfo(zoneApplyList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("zonePage");
        return mv;
    }



}
