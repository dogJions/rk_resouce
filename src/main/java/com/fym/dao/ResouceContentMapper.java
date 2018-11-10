package com.fym.dao;

import com.fym.entity.ResouceContent;

import java.util.List;
import java.util.Map;

public interface ResouceContentMapper {

    List<ResouceContent> selectByText(Map<String,Object> map);

    List<ResouceContent> selectIndex();

    List<ResouceContent> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(ResouceContent record);

    int insertSelective(ResouceContent record);

    ResouceContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceContent record);

    int updateByPrimaryKey(ResouceContent record);
}