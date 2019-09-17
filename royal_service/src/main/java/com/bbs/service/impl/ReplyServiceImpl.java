package com.bbs.service.impl;

import com.bbs.dao.ReplyDao;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    /**
     * 查询所有回复
     * @return
     */
    @Override
    public List getReplyList() {
        return replyDao.getReplyList();
    }
}
