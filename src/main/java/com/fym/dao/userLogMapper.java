package com.fym.dao;

import com.fym.entity.userLog;

import java.util.List;

public interface userLogMapper {

    List<userLog> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(userLog record);

    int insertSelective(userLog record);

    userLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(userLog record);

    int updateByPrimaryKeyWithBLOBs(userLog record);

    int updateByPrimaryKey(userLog record);
}