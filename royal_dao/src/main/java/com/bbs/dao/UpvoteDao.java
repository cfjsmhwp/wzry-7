package com.bbs.dao;

import com.bbs.domain.Upvote;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteDao {

    /**
     * 点赞
     * @param upvote
     */
    @Insert("insert into bbs_upvote_table (upvoteUserName,upvoteArticleId,isUpvote) values (#{upvoteUserName},#{upvoteArticleId},#{isUpvote})")
    void addUpvote(Upvote upvote);
}



