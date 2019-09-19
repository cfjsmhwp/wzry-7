package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;
import java.util.Date;

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

    @Override
    public void register(User user) throws Exception {
        userDao.register(user);
    }

    @Override
    public User login(String userName, String userPass) throws Exception {
        return userDao.login(userName,userPass);
    }

    @Override
    public User findByUserName(String userName) throws Exception {
        return userDao.findByUserName(userName);
    }

    @Override
    public void updateLoginTime(String userName, Date date) throws Exception {
        userDao.updateLoginTime(userName,date);
    }

    @Override
    public int update(String userName, String email, String picUrl) {
        return userDao.update(userName,email,picUrl);
    }

    @Override
    public void updatePwd(String userName, String oldPassword, String newPassword) {
        userDao.updatePwd(userName,oldPassword,newPassword);
    }

    @Override
    public int applyUpgrade(String userName) {
        int flag = userDao.applyUpgrade(userName);
        return flag;
    }

}
