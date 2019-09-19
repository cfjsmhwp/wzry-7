package com.bbs.domain;

public class ZoneApply {
    private int applyZoneId;
    //新版块名
    private String zoneName;
    //用户名
    private String userName;
    //申请原因
    private String reason;
    //处理状态（未处理0，已处理1）
    private int status;
    private String statusStr;

    public int getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(int applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
