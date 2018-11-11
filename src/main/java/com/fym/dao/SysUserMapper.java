package com.fym.dao;

import com.fym.entity.SysUser;

import java.util.List;

public interface SysUserMapper {

    List<SysUser> selectAll();

    SysUser selectByName(String name);

    String selectByLogin(String name);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKeyWithBLOBs(SysUser record);

    int updateByPrimaryKey(SysUser record);
}