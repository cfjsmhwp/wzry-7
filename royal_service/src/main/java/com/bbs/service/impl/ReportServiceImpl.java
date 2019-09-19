package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
    @Override
    public List<Report> getReportList(int page) {
        PageHelper.startPage(page, 6);
        return reportDao.getReportList();
    }

    @Override
    public List<Report> deleteArticle(String reportId, int pn, int articleStatus) {

            if (articleStatus==0){
                reportDao.deleteArticle(reportId);
            }else if (articleStatus==1){
                reportDao.showArticle(reportId);
            }
            PageHelper.startPage(pn, 6);
            return reportDao.getReportList();

        }
    }

