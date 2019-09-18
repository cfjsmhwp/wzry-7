package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.UserInfo;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
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
    public List<UserInfo> findByPage() {
        return userDao.findByPage();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserName(), userInfo.getUserPass(), userInfo.getLoginStatus()==0?false:true, true, true, true, getAuthority(userInfo));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(UserInfo userInfo) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        if (userInfo.getRole() == 3) {
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return list;
    }
}
