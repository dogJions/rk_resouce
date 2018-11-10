package com.fym.controller;

import com.fym.entity.*;
import com.fym.service.RContentService;
import com.fym.util.UtilsTest01;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/map")
public class Indexmap extends BaseController{

    /**
     * 查分级分类
     * @param pid 上一级分类id
     * @return
     */
    @RequestMapping("/Catalog")
    public Map<String,Object> Catalog(long pid){
        Map<String,Object> map=new HashMap<>();
        map.put("rc",rCatalogService.selectSonCa(pid) );
        return map;
    }

    /**
     * 查当前分类下数据
     * @param cid 分类id
     * @param hiv 最新or最热 1新 2热
     * @param pageNum 当前页码数
     * @param  siteType 文件种类
     * @return
     */
    //, required = false, defaultValue = "1"
    @RequestMapping("/text_list")
    public PageInfo<ResouceContent> contentList(@RequestParam(value = "cid" ) int cid,
                                                @RequestParam(value = "hiv" )int hiv,
                                                @RequestParam(value = "pageNum" )int pageNum,
                                                @RequestParam(value = "siteType" )int siteType){
        System.err.println(cid+"/"+hiv+"/"+pageNum);
        return rcService.clist(cid, hiv, pageNum,siteType);
    }

    /**
     * 视频详情页的视频链接与集数
     * @param cid
     * @return
     */
    @RequestMapping("/void_dateiled")
    public List<ResouceVideo> videoD(long cid){
        return rvService.selectByCid(cid) ;
    }

    /**
     * 文件下载
     * @param id
     * @param res
     * @param session
     * @throws IOException
     */
    @RequestMapping("/down")
    public void down(long id , HttpServletResponse res, HttpSession session) throws IOException {
        ResouceDownloadFile rdf=rdfService.selectById(id);
        UtilsTest01 ut=new UtilsTest01();
        ut.down(rdf.getUrl(),res,session);
    }

    /**
     * 首页显示
     * @param pageNum
     * @return
     */
    @RequestMapping("/index_list")
    public PageInfo<ResouceContent> indexList(@RequestParam(value = "page", required = false, defaultValue = "1")int pageNum){
        return rcService.selectindex(pageNum);
    }

    /**
     * 文件上传
     * @param multipartFile 文件上传接口
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public Map<String,Object> upload(@RequestParam(value = "file") MultipartFile multipartFile,HttpSession session) throws IOException {
        SimpleDateFormat adf=new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss");

        String path="f:"+ File.separator+"file";
        //文件的名称
        String fileName=adf.format(new Date());

        //获取上传文件的名字
        String orgFileName=multipartFile.getOriginalFilename();
        //获取文件的扩展名
        String ext=orgFileName.substring(orgFileName.lastIndexOf("."));
        String saveFilePath=path+ File.separator+fileName+ext;
        System.err.println(saveFilePath);
        //保存上传文件
        multipartFile.transferTo(new File(saveFilePath));

        Map<String,Object> resultMap=new HashMap<String, Object>();
        Map<String,Object> map=new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","???");
        map.put("src","/file/"+fileName+ext);
        resultMap.put("data",map);

        return resultMap;
    }

    @RequestMapping("/addmsg")
    public String addMsg(Message msg){
        msg.setAddTime(new Date());
        System.err.println(msg);
        msgService.add(msg);
        return "提交成功";
    }
}
