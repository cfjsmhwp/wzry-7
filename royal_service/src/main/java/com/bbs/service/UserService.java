package com.bbs.service;

import com.bbs.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;

public interface UserService extends UserDetailsService {

    void addPost(Comment comment);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();

    List<UserInfo> findByPage(int page, int size);

    void register(UserInfo user) throws Exception;

    UserInfo login(String userName, String userPass) throws Exception;

    UserInfo findByUserName(String userName) throws Exception;

    void updateLoginTime(String userName, Date date) throws  Exception;

    int update(String userName, String email, String picUrl);

    void updatePwd(String userName, String oldPassword, String newPassword);

    int applyUpgrade(String userName);
}
