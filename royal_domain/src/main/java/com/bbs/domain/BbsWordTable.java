package com.bbs.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import javax.xml.ws.Service;

public class BbsWordTable {
    private Integer wordId;
    private String word;
    private String status;
    private String statusStr;

    public String getStatusStr() {
        if (status!=null){
            if (status=="0"){
                statusStr="启用";
            }else if (status=="1"){
                statusStr="不启用";

            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
