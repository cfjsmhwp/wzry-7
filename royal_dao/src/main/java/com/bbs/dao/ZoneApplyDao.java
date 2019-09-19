package com.bbs.dao;

import com.bbs.domain.ZoneApply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneApplyDao {
    /**
     * 查询所有申请审核的板块
     * @return
     * @throws Exception
     */
    @Select("select * from bbs_zoneapply_table where status = 0 ")
    List<ZoneApply> findAllZoneApply() throws Exception;

    /**
     * 更新处理状态
     * @param applyZoneId
     * @throws Exception
     */
    @Update("update bbs_zoneapply_table set status = 1 where applyZoneId = #{applyZoneId}")
    void updateStatus(Integer applyZoneId) throws Exception;

}
