package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Report;

import java.util.List;

public interface ReportService {
    List<Report> getReportList(int page);

    List<Report> deleteArticle(String reportId, int pn, int articleStatus);
}
