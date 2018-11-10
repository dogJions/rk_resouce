package com.fym.dao;

import com.fym.entity.ResouceCatalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResouceCatalogMapper {

    List<ResouceCatalog> selectOneCa(@Param(value = "sitpId")long sitpId);

    List<ResouceCatalog> selectSonCa(@Param(value = "pid")long pid);

    List<ResouceCatalog> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(ResouceCatalog record);

    int insertSelective(ResouceCatalog record);

    ResouceCatalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceCatalog record);

    int updateByPrimaryKeyWithBLOBs(ResouceCatalog record);

    int updateByPrimaryKey(ResouceCatalog record);
}