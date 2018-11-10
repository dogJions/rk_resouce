package com.fym.service.imp;

import com.fym.dao.AdConfigMapper;
import com.fym.entity.AdConfig;
import com.fym.service.AdConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdConfigServiceImp implements AdConfigService {
    @Autowired
    AdConfigMapper mapper;

    @Override
    @Transactional
    public List<AdConfig> selectAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional
    public void add(AdConfig adConfig) {
        mapper.insert(adConfig);
    }

    @Override
    @Transactional
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void update(AdConfig adConfig) {
        mapper.updateByPrimaryKey(adConfig);
    }

    @Override
    @Transactional
    public AdConfig selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
