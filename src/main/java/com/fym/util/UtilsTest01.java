package com.fym.util;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsTest01 {

    public void down( String path,HttpServletResponse res,HttpSession session) throws IOException {

        SimpleDateFormat adf=new SimpleDateFormat("yyyy_MM_dd");
        String pathTest1="f:"+File.separator+"file";
        //临时文件
        System.err.println(pathTest1+path);

        //获取文件扩展名
        String mimeType=path.substring(path.lastIndexOf("."));
        //指定下载文件的名字与浏览器强制下载
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + adf.format(new Date())+mimeType);


        ServletOutputStream out= res.getOutputStream();
        FileInputStream in=new FileInputStream(pathTest1+path);
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        in.close();
    }
}
