package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private int userId;//ID
    private String userName;//用户账号
    private String userPass;//密码
    private String email;//邮箱
    private String picUrl;//头像路径
    private int role;//用户权限 1代表普通用户；2代表高级用户，3代表超级管理员
    private String roleStr;
    private Date lastLoginTime;//最后登录时间
    private String lastLoginTimeStr;
    private int loginStatus;//登录状态，0代表未登录，1代表已登录
    private String loginStatusStr;
    private int talkStatus;//发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
    private String talkStatusStr;
    private int isupdating;//申请升级(0-未申请,1-已申请)
    private String isupdatingStr;
    private int updateStatus;//申请升级审核状态(0-未处理,1-已处理)
    private String updateStatusStr;

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

    public String getLoginStatusStr() {
        return loginStatusStr;
    }

    public void setLoginStatusStr(String loginStatusStr) {
        this.loginStatusStr = loginStatusStr;
    }

    public String getIsupdatingStr() {
        return isupdatingStr;
    }

    public void setIsupdatingStr(String isupdatingStr) {
        this.isupdatingStr = isupdatingStr;
    }

    public String getUpdateStatusStr() {
        return updateStatusStr;
    }

    public void setUpdateStatusStr(String updateStatusStr) {
        this.updateStatusStr = updateStatusStr;
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
