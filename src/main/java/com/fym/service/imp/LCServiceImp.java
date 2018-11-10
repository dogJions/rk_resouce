package com.fym.service.imp;

import com.fym.dao.LinkConfigMapper;
import com.fym.entity.LinkConfig;
import com.fym.service.LCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LCServiceImp implements LCService {

    @Autowired
    LinkConfigMapper mapper;

    @Override
    public List<LinkConfig> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(LinkConfig linkConfig) {
        mapper.insert(linkConfig);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(LinkConfig linkConfig) {
        mapper.updateByPrimaryKey(linkConfig);
    }

    @Override
    public LinkConfig selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
