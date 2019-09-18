package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.util.Date;

public class UserInfo {
    private int userId;
    private String userName;
    private String userPass;
    private String email;
    private String picUrl;
    private int role;
    private String roleStr;
    private Date lastLoginTime;
    private String lastLoginTimeStr;
    private int loginStatus;
    private int talkStatus;
    private String talkStatusStr;
    private int isupdating;
    private int updateStatus;

    public String getTalkStatusStr() {
        if (talkStatus == 0){
            talkStatusStr = "否";
        }else if (talkStatus == 1){
            talkStatusStr = "是";
        }
        return talkStatusStr;
    }

    public void setTalkStatusStr(String talkStatusStr) {
        this.talkStatusStr = talkStatusStr;
    }


    public String getRoleStr() {
        if (role == 1){
            roleStr = "普通用户";
        }else if (role == 2){
            roleStr = "高级用户";
        }else if (role == 3){
            roleStr = "超级管理员";
        }
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public String getLastLoginTimeStr() {
        if (lastLoginTime != null) {
            lastLoginTimeStr = DateUtils.date2String(lastLoginTime, "yyyy-MM-dd HH:mm:ss");
        } else {
            lastLoginTimeStr = "未知时间";
        }
        return lastLoginTimeStr;
    }

    public void setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
    }

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
