package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReportDao {
    @Select("select * from bbs_report_table")
    List<Report> getReportList();
    @Update(" UPDATE bbs_report_table SET reportStatus=1 WHERE reportId=#{reportId}")
    void deleteArticle(@Param("reportId")String reportId);
    @Update("UPDATE bbs_report_table SET reportStatus=0 WHERE reportId=#{reportId}")
    void showArticle(@Param("reportId") String reportId);
}
