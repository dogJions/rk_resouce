package com.fym.dao;

import com.fym.entity.AdConfig;

import java.util.List;

public interface AdConfigMapper {

    List<AdConfig> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(AdConfig record);

    int insertSelective(AdConfig record);

    AdConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdConfig record);

    int updateByPrimaryKey(AdConfig record);
}