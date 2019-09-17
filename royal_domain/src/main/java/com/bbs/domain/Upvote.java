package com.bbs.domain;

//点赞表bbs_Upvote_table对应的类
public class Upvote {

    //点赞人
    private String upvoteUserName;
    //点赞帖子
    private Integer upvoteArticleId;
    //点赞状态，0代表未点赞，1代表已点赞（默认）
    private Integer isUpvote = 0;

    public String getupvoteUserName() {
        return upvoteUserName;
    }

    public void setupvoteUserName(String upvoteUserName) {
        this.upvoteUserName = upvoteUserName;
    }

    public Integer getupvoteArticleId() {
        if (isUpvote == 0){
            isUpvote = 1;
        }else if (isUpvote == 1){
            isUpvote = 0;
        }
        return upvoteArticleId;
    }

    public void setupvoteArticleId(Integer upvoteArticleId) {
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
