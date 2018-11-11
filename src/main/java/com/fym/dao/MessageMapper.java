package com.fym.dao;

import com.fym.entity.Message;

import java.util.List;

public interface MessageMapper {

    int selectByCon();

    List<Message> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}