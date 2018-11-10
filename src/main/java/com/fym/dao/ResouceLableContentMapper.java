package com.fym.dao;

import com.fym.entity.ResouceLableContent;

public interface ResouceLableContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResouceLableContent record);

    int insertSelective(ResouceLableContent record);

    ResouceLableContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceLableContent record);

    int updateByPrimaryKey(ResouceLableContent record);
}