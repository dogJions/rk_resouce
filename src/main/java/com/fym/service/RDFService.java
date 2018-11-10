package com.fym.service;

import com.fym.entity.ResouceDownloadFile;
import org.springframework.stereotype.Service;


public interface RDFService extends BaseService<ResouceDownloadFile>{

    /**
     * 软件详情页查询
     * @param cid
     * @return
     */
    ResouceDownloadFile selectByCid(long cid);
}
