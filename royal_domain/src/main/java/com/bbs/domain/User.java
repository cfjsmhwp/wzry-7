package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String userPass;
    private String email;
    private String picUrl;
    private Integer role;
    private Date lastLoginTime;
    private Integer loginStatus;
    private Integer talkStatus;
    private Integer isupdating;
    private Integer updateStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(Integer talkStatus) {
        this.talkStatus = talkStatus;
    }

    public Integer getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(Integer isupdating) {
        this.isupdating = isupdating;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
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
