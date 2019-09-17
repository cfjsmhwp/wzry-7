package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 发帖，添加帖子
     * @param comment
     */
    @Override
    public void addPost(Comment comment) {
        userDao.addPost();
    }

    @Override
    public Integer findOnlineUserCount() {
        return userDao.findOnlineUserCount();
    }

    @Override
    public String[] findOnlineUserName() {
        return userDao.findOnlineUserName();
    }

}
