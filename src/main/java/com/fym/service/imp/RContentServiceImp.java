package com.fym.service.imp;

import com.fym.dao.ResouceCatalogMapper;
import com.fym.dao.ResouceContentMapper;
import com.fym.dao.ResouceLableMapper;
import com.fym.entity.ResouceContent;
import com.fym.service.RContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RContentServiceImp implements RContentService {

    @Autowired
    ResouceContentMapper mapper;

    @Autowired
    ResouceCatalogMapper RCMapper;

    @Override
    public PageInfo<ResouceContent> selectindex(int pageNum) {
        PageHelper.startPage(pageNum,5);
       List<ResouceContent> list= mapper.selectIndex();
        for (ResouceContent t:list) {
            t.setRCatalog(RCMapper.selectByPrimaryKey(Long.valueOf(t.getCatalogId())).getName());
        }
        PageInfo<ResouceContent> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<ResouceContent> clist(int cid, int hiv, int pageNum,int siteType) {
        PageHelper.startPage(pageNum,5);
        Map<String,Object> map=new HashMap<>();
        map.put("cid",cid);
        map.put("hotOrNew",hiv);
        map.put("siteType",siteType);
        List<ResouceContent> resouceContentList=mapper.selectByText(map);
        PageInfo<ResouceContent> info=new PageInfo<>(resouceContentList);
        return info;
    }

    @Override
    public List<ResouceContent> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(ResouceContent resouceContent) {
        mapper.insert(resouceContent);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ResouceContent resouceContent) {
        mapper.updateByPrimaryKey(resouceContent);
    }

    @Override
    public ResouceContent selectById(long id) {
        ResouceContent rc= mapper.selectByPrimaryKey(id);
        rc.setRCatalog(RCMapper.selectByPrimaryKey(Long.valueOf(rc.getCatalogId())).getName());
        return rc;
    }
}
