package com.fym.controller;

import com.fym.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

//    广告表
    @Autowired
    AdConfigService adConfigService;

    //【资源标签表】
    @Autowired
    RLService rlService;

    //视频资源表
    @Autowired
    RVService rvService;

    //友情链接表
    @Autowired
    LCService lcService;

    //【资源内容表】
    @Autowired
    RContentService rcService;

    //【资源分类表】
    @Autowired
    RCatalogService rCatalogService;

    //【文件下载资源表】
    @Autowired
    RDFService rdfService;

    //留言表
    @Autowired
    MsgService msgService;
}
