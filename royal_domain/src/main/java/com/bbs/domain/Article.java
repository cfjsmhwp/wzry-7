package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//帖子表bbs_article_table对应的类
public class Article implements Serializable {

    //帖子编号
    private Integer articleId;
    //标题
    private String title;
    //内容
    private String content;
    //发送时间
    private Date sendTime;
    //发送人编号
    private String senderName;
    //是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private Integer isTop;

    private String isTopStr;



    //评论数
    private Integer replyCount;
    //点赞数
    private Integer upvoteCount;
    //浏览数
    private Integer browseCount;
    //所在交流区
    private Integer zoneId;

    private String zoneIdStr;
    //举报状态
    private Integer isReport;
    //一对多的评论集合
    private List<Comment> commentList;

    private String sendTimeStr;

    //是否屏蔽0为屏蔽，1为显示
    private  int articleStatus;

    public int getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getZoneIdStr() {
        if (zoneId!=null) {
            if (zoneId==1) {
                zoneIdStr="综合交流区";
            }
        }
        return zoneIdStr;
    }

    public void setZoneIdStr(String zoneIdStr) {
        this.zoneIdStr = zoneIdStr;
    }

    public String getIsTopStr() {
        if (isTop!=null) {
            if (isTop==0){
                isTopStr="否";
            }else if (isTop==1){
                isTopStr="是";
            }
        }
        return isTopStr;
    }

    public void setIsTopStr(String isTopStr) {
        this.isTopStr = isTopStr;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getSendTimeStr() {
        String time = DateUtils.date2String(sendTime, "yyyy-MM-dd HH:mm:ss");
        return time;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", isTopStr='" + isTopStr + '\'' +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zoneId=" + zoneId +
                ", zoneIdStr='" + zoneIdStr + '\'' +
                ", isReport=" + isReport +
                ", commentList=" + commentList +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                '}';
    }
}
