package com.fym.dao;

import com.fym.entity.ResouceVideo;

import java.util.List;

public interface ResouceVideoMapper {

    List<ResouceVideo> selectByCid(Long id);

    List<ResouceVideo> selectByRecommend();

    List<ResouceVideo> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(ResouceVideo record);

    int insertSelective(ResouceVideo record);

    ResouceVideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceVideo record);

    int updateByPrimaryKey(ResouceVideo record);
}