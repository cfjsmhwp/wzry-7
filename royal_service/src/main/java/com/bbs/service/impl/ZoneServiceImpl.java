package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.domain.Zone;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneDao zoneDao;

    /**
     * 查询所有空间
     */
    @Override
    public List<Zone> getZoneList() {

        return zoneDao.getZoneList();
    }

    @Override
    public List<Zone> findAllZone() {
        return zoneDao.findAllZone();
    }

    @Override
    public int save(String userName, String zoneName, String reason) {
        return zoneDao.save(userName,zoneName,reason);
    }

    @Override
    public void addZone(String zoneName) throws Exception {
        zoneDao.addZone(zoneName,2);
    }
}
