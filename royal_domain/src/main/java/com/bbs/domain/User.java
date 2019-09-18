package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    int userId;          //userId int(11) NOT NULL用户ID
    String userName;     //userName varchar(50) NOT NULL用户名
    String userPass;     //userPass varchar(255) NOT NULL密码
    String email;        //email varchar(255) NULL邮箱
    String picUrl;       //picUrl varchar(255) NULL头像
    int role;            //role int(11) NOT NULL1代表普通用户；2代表高级用户，3代表超级管理员
    Date lastLoginTime;  //lastLoginTime datetime NULL最后登录时间
    int loginStatus;     //loginStatus int(11) NULL登录状态，0代表未登录，1代表已登录
    int talkStatus;      //talkStatus int(11) NOT NULL发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
    int isupdating;      //isupdating int(2) NULL申请升级(0-未申请,1-已申请)
    int updateStatus;    //updateStatus int(2) unsigned NULL申请升级审核状态(0-未处理,1-已处理)

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(int talkStatus) {
        this.talkStatus = talkStatus;
    }

    public int getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(int isupdating) {
        this.isupdating = isupdating;
    }

    public int getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(int updateStatus) {
        this.updateStatus = updateStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", email='" + email + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", role=" + role +
                ", lastLoginTime=" + lastLoginTime +
                ", loginStatus=" + loginStatus +
                ", talkStatus=" + talkStatus +
                ", isupdating=" + isupdating +
                ", updateStatus=" + updateStatus +
                '}';
    }
}
