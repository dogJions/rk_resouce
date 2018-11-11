package com.fym.service;

import com.fym.entity.ResouceContent;
import com.fym.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RContentService extends BaseService<ResouceContent> {
    /**
     * 首页精选
     * @return
     */
    PageInfo<ResouceContent> selectindex(int pageNum);

    /**
     * 资源查询
     * @param cid 资源分类
     * @param hiv 1最热 2 最新
     * @param pageNum 当前页码数
     * @return
     */
    public PageInfo<ResouceContent> clist(int cid,int hiv,int pageNum,int siteType);

    /**
     * 后台控制台资源数查询
     * @param sitepid 资源分类
     * @return
     */
    int selectByCon (int sitepid);
}
