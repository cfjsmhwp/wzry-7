package com.bbs.domain;

//点赞表bbs_Upvote_table对应的类
public class Upvote {

    //点赞人
    private String UpvoteUserName;
    //点赞帖子
    private Integer UpvoteArticleId;
    //点赞状态，0代表未点赞，1代表已点赞（默认）
    private Integer isUpvote = 0;

    public String getUpvoteUserName() {
        return UpvoteUserName;
    }

    public void setUpvoteUserName(String UpvoteUserName) {
        this.UpvoteUserName = UpvoteUserName;
    }

    public Integer getUpvoteArticleId() {
        if (isUpvote == 0){
            isUpvote = 1;
        }else if (isUpvote == 1){
            isUpvote = 0;
        }
        return UpvoteArticleId;
    }

    public void setUpvoteArticleId(Integer UpvoteArticleId) {
        this.UpvoteArticleId = UpvoteArticleId;
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
                "UpvoteUserName='" + UpvoteUserName + '\'' +
                ", UpvoteArticleId=" + UpvoteArticleId +
                ", isUpvote=" + isUpvote +
                '}';
    }
}
