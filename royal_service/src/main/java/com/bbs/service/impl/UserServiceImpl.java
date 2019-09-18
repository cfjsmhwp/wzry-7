package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;

@Service
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

    /**
     * 根据用户名，密码验证登录
     * @param userName
     * @param userPass
     * @return
     */

    public User findUserByUserNameAndUserPass(String userName, String userPass) {
        User user = userDao.findUserByUserNameAndUserPass(userName,userPass);
        return user;
    }

    @Override
    public int update(String userName, String email, String picUrl) {
        return userDao.update(userName,email,picUrl);
    }

    @Override
    public int applyUpgrade(String userName) {
        int flag = userDao.applyUpgrade(userName);
        return flag;
    }

    @Override
    public void updatePwd(String userName, String oldPassword, String newPassword) {
        userDao.updatePwd(userName,oldPassword,newPassword);
    }

}
