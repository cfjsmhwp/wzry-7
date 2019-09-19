package com.bbs.service;

import com.bbs.domain.Zone;

import java.util.List;

public interface ZoneService {

    //查询所有空间
    List<Zone> getZoneList();

    List<Zone> findAllZone();

    int save(String userName, String zoneName, String reason);

    void addZone(String zoneName) throws Exception;

}
