package com.fym.service.imp;

import com.fym.dao.ResouceDownloadFileMapper;
import com.fym.entity.ResouceDownloadFile;
import com.fym.service.RDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RDFServiceImp implements RDFService {
    @Autowired
    ResouceDownloadFileMapper mapper;

    @Override
    public ResouceDownloadFile selectByCid(long cid) {
        return mapper.selectByCid(cid);
    }

    @Override
    public List<ResouceDownloadFile> selectAll() {
        return null;
    }

    @Override
    public void add(ResouceDownloadFile resouceDownloadFile) {
        mapper.insert(resouceDownloadFile);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ResouceDownloadFile resouceDownloadFile) {
        mapper.updateByPrimaryKey(resouceDownloadFile);
    }

    @Override
    public ResouceDownloadFile selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
