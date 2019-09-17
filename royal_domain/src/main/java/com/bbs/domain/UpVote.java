package com.bbs.domain;

//点赞表bbs_upvote_table对应的类
public class UpVote {

    //点赞人
    private String upvoteUserName;
    //点赞帖子
    private Integer upvoteArticleId;
    //点赞状态，0代表未点赞，1代表已点赞（默认）
    private Integer isUpvote;

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
        return "UpVote{" +
                "upvoteUserName='" + upvoteUserName + '\'' +
                ", upvoteArticleId=" + upvoteArticleId +
                ", isUpvote=" + isUpvote +
                '}';
    }
}
