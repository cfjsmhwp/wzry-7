package com.bbs.controller;

import com.bbs.domain.Zone;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;
    /**
     * 查询所有空间
     * @return
     */
    @RequestMapping("/getZoneList")
    public ModelAndView getZoneList(){
        ModelAndView mv = new ModelAndView();
        List<Zone> zoneList = zoneService.getZoneList();
        mv.addObject("zoneList",zoneList);
        mv.setViewName("zone-list");
        return mv;
    }

    /**
     * 开辟新板块申请
     * @param response
     * @param userName
     * @param zoneName
     * @param reason
     * @throws Exception
     */
    @RequestMapping("/apply")
    public void ZoneApply(HttpServletResponse response, String userName, String zoneName, String reason)throws Exception{
        int flag = zoneService.save(userName,zoneName,reason);
        if (flag>0){
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print("申请成功");
        }
    }
}
