package com.bbs.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import javax.xml.stream.events.Comment;

public interface UserService extends UserDetailsService {

    void addPost(Comment comment);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();
}
