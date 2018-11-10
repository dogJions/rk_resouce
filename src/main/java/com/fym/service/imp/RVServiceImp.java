package com.fym.service.imp;

import com.fym.dao.ResouceVideoMapper;
import com.fym.entity.ResouceVideo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RVServiceImp implements com.fym.service.RVService {

    @Autowired
    ResouceVideoMapper mapper;

    @Override
    public PageInfo<ResouceVideo> selectByRecommend() {
        PageHelper.startPage(1,3);
        List<ResouceVideo> list=mapper.selectByRecommend();
        PageInfo<ResouceVideo> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public List<ResouceVideo> selectByCid(long id) {
        return mapper.selectByCid(id);
    }

    @Override
    public List<ResouceVideo> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(ResouceVideo resouceVideo) {
        mapper.insert(resouceVideo);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ResouceVideo resouceVideo) {
        mapper.updateByPrimaryKey(resouceVideo);
    }

    @Override
    public ResouceVideo selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
