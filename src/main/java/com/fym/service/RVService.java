package com.fym.service;

import com.fym.entity.ResouceVideo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RVService extends BaseService<ResouceVideo> {

    /**
     * 查首页推荐 点击顺序查询 只显示前三条
     */
    PageInfo<ResouceVideo> selectByRecommend();

    /**
     * 视频详情页的视频链接与集数
     * @param id
     * @return
     */
    List<ResouceVideo> selectByCid(long id);
}
