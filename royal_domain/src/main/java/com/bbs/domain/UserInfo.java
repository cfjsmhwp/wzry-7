package com.bbs.domain;

import java.util.Date;

public class UserInfo {
    private int userId;
    private String userName;
    private String userPass;
    private String email;
    private String picUrl;
    private int role;
    private Date lastLoginTime;
    private int loginStatus;
    private int talkStatus;
    private int isupdating;
    private int updateStatus;

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
}
