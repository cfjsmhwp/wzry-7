package com.bbs.domain;

//点赞表bbs_Upvote_table对应的类
public class Upvote {

    //点赞人
    private String upvoteUserName;
    //点赞帖子
    private Integer upvoteArticleId;
    //点赞状态，0代表未点赞，1代表已点赞（默认）
    private Integer isUpvote = 0;

    public String getUpvoteUserName() {
        return upvoteUserName;
    }

    public void setUpvoteUserName(String upvoteUserName) {
        this.upvoteUserName = upvoteUserName;
    }

    public Integer getUpvoteArticleId() {
        return upvoteArticleId;
    }

    public void setUpvoteArticleId(Integer upvoteArticleId) {
        this.upvoteArticleId = upvoteArticleId;
    }

    public Integer getIsUpvote() {
        return isUpvote;
    }

    public void setIsUpvote(Integer isUpvote) {
        this.isUpvote = isUpvote;
    }

    @Override
    public String toString() {
        return "Upvote{" +
                "upvoteUserName='" + upvoteUserName + '\'' +
                ", upvoteArticleId=" + upvoteArticleId +
                ", isUpvote=" + isUpvote +
                '}';
    }
}
