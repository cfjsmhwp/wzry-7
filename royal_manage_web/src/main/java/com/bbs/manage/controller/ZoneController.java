package com.bbs.manage.controller;

import com.bbs.service.ZoneApplyService;
import com.bbs.service.ZoneService;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private ZoneApplyService zoneApplyService;

    /**
     * 板块审核--驳回
     * @param applyZoneId
     * @param page
     * @return
     * @throws Exception
     */
   @RequestMapping("/changeStatus.do")
   public String changeStatus( @RequestParam("applyZoneId") Integer applyZoneId,
                               @RequestParam("page") Integer page) throws Exception {
       zoneApplyService.updateStatus(applyZoneId);

       return "redirect:/zoneApply/findAll.do?pageNum="+page;
   }


    /**
     * 板块审核--同意
     * @param page
     * @return
     */
    @RequestMapping("/addZone.do")
    public String addZone(HttpServletRequest request,Integer page) throws Exception {
        String zoneName =null;
        try {
            zoneName = new String(request.getParameter("zoneName").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        zoneService.addZone(zoneName);
        Integer applyZoneId = Integer.parseInt(request.getParameter("applyZoneId"));
        zoneApplyService.updateStatus(applyZoneId);
        return "redirect:/zoneApply/findAll.do?pageNum="+page;
    }

}
