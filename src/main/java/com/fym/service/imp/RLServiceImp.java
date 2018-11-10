package com.fym.service.imp;

import com.fym.dao.ResouceLableMapper;
import com.fym.entity.ResouceLable;
import com.fym.service.RLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RLServiceImp implements RLService {

    @Autowired
    ResouceLableMapper mapper;

    @Override
    public List<ResouceLable> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(ResouceLable resouceLable) {
        mapper.insert(resouceLable);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ResouceLable resouceLable) {
        mapper.updateByPrimaryKey(resouceLable);
    }

    @Override
    public ResouceLable selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
