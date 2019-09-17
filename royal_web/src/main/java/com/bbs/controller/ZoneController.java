package com.bbs.controller;

import com.bbs.domain.Zone;
import com.bbs.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {

    private ZoneService zoneService;
    /**
     * 查询所有空间
     * @return
     */
    @RequestMapping("/getZoneList.do")
    public ModelAndView getZoneList(){
        ModelAndView mv = new ModelAndView();
        List<Zone> zoneList = zoneService.getZoneList();
        mv.addObject("zoneList",zoneList);
        mv.setViewName("zone-list");
        return mv;
    }
}
