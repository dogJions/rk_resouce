package com.fym.dao;

import com.fym.entity.ResouceDownloadFile;

public interface ResouceDownloadFileMapper {

    ResouceDownloadFile selectByCid(long cid);

    int deleteByPrimaryKey(Long id);

    int insert(ResouceDownloadFile record);

    int insertSelective(ResouceDownloadFile record);

    ResouceDownloadFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResouceDownloadFile record);

    int updateByPrimaryKey(ResouceDownloadFile record);
}