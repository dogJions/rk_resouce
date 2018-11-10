package com.fym.dao;

import com.fym.entity.LinkConfig;

import java.util.List;

public interface LinkConfigMapper {

    List<LinkConfig> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(LinkConfig record);

    int insertSelective(LinkConfig record);

    LinkConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LinkConfig record);

    int updateByPrimaryKeyWithBLOBs(LinkConfig record);

    int updateByPrimaryKey(LinkConfig record);
}