package com.fym.service;

import com.fym.entity.ResouceCatalog;

import java.util.List;

public interface RCatalogService extends  BaseService<ResouceCatalog> {

    /**
     * 一级分类
     * @param sitpId
     * @return
     */
    List<ResouceCatalog> selectOneCa(int sitpId);

    /**
     * 子分类
     * @param pid
     * @return
     */
    List<ResouceCatalog> selectSonCa(long pid);
}
