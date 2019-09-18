package com.bbs.service;

import com.bbs.domain.Zone;

import java.util.List;

public interface ZoneService {

    //查询所有空间
    List<Zone> getZoneList();

    int save(String userName, String zoneName, String reason);
}
