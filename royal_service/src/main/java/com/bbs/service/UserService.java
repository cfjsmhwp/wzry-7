package com.bbs.service;

import javax.xml.stream.events.Comment;

public interface UserService {

    void addPost(Comment comment);

    Integer findOnlineUserCount();

    String[] findOnlineUserName();
}
