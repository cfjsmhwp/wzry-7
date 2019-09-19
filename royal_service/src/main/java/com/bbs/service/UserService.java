package com.bbs.service;

import com.bbs.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface UserService extends UserDetailsService {

    void addPost(Comment comment);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();

    List<UserInfo> findByPage(int page,int size);
}
