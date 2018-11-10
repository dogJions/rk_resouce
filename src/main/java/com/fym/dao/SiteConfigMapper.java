package com.fym.dao;

import com.fym.entity.SiteConfig;

public interface SiteConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SiteConfig record);

    int insertSelective(SiteConfig record);

    SiteConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SiteConfig record);

    int updateByPrimaryKey(SiteConfig record);
}