package com.bbs.service.impl;

import com.bbs.dao.ZoneApplyDao;
import com.bbs.domain.ZoneApply;
import com.bbs.service.ZoneApplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneApplyServiceImpl implements ZoneApplyService {

    @Autowired
    private ZoneApplyDao zoneApplyDao;

    @Override
    public List<ZoneApply> findAllZoneApply(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return zoneApplyDao.findAllZoneApply();
    }

    @Override
    public void updateStatus(Integer applyZoneId) throws Exception {
        zoneApplyDao.updateStatus(applyZoneId);
    }
}
