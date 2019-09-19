package com.bbs.service;

import com.bbs.domain.ZoneApply;

import java.util.List;

public interface ZoneApplyService {

    List<ZoneApply> findAllZoneApply(Integer pageNum, Integer pageSize) throws Exception;

    void updateStatus(Integer applyZoneId) throws Exception;
}
