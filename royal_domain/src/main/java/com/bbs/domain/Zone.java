package com.bbs.domain;

import java.io.Serializable;
import java.util.List;

//空间表bbs_zone_table对应的类
public class Zone implements Serializable {

    //交流区编号
    private Integer zoneId;
    //交流区名字
    private String zoneName;
    //是否默认，1代表默认，2代表非默认
    private Integer isDef;
    //一对多的帖子集合
    private List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneId=" + zoneId +
                ", zoneName='" + zoneName + '\'' +
                ", isDef=" + isDef +
                '}';
    }
}
