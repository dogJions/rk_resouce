package com.fym.service.imp;

import com.fym.dao.ResouceCatalogMapper;
import com.fym.dao.ResouceContentMapper;
import com.fym.entity.ResouceCatalog;
import com.fym.service.RCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RCatalogServiceImp implements RCatalogService {

    @Autowired
    ResouceCatalogMapper mapper;

    @Override
    public List<ResouceCatalog> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(ResouceCatalog resouceCatalog) {
        mapper.insert(resouceCatalog);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ResouceCatalog resouceCatalog) {
        mapper.updateByPrimaryKey(resouceCatalog);
    }

    @Override
    public ResouceCatalog selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<ResouceCatalog> selectOneCa(int sitpId){
        return mapper.selectOneCa(sitpId);
    }

    @Override
    public List<ResouceCatalog> selectSonCa(long pid) {
        return mapper.selectSonCa(pid);
    }


    //添加子类
//    public List<ResouceCatalog> addSon(List<ResouceCatalog> faList){
//        for (ResouceCatalog rc:faList) {
//            if(mapper.selectSonCa(rc.getId())==null){
//                continue;
//            }else {
//                List<ResouceCatalog> sonList= mapper.selectSonCa(rc.getId());
//                RCatalogServiceImp rs=new RCatalogServiceImp();
//                List<ResouceCatalog>  FSonlist=rs.addSon(sonList);
//               rc.setRCList(FSonlist);
//            }
//        }
//        return faList;
//    }
}
