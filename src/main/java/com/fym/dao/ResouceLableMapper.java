package com.fym.dao;

import com.fym.entity.ResouceLable;

import java.util.List;

public interface ResouceLableMapper {

    List<String> selectRCLable(Long id);

    List<ResouceLable> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(ResouceLable record);

    int insertSelective(ResouceLable record);

    ResouceLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceLable record);

    int updateByPrimaryKeyWithBLOBs(ResouceLable record);

    int updateByPrimaryKey(ResouceLable record);
}