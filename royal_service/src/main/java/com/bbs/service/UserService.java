package com.bbs.service;

import com.bbs.domain.User;

import javax.xml.stream.events.Comment;

public interface UserService {

    void addPost(Comment comment);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();

    User findUserByUserNameAndUserPass(String userName, String userPass);

    int update(String userName, String email, String picUrl);

    int applyUpgrade(String userName);

    void updatePwd(String userName, String oldPassword, String newPassword);
}
