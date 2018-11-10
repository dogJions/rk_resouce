package com.fym.entity;

import java.util.Date;
import java.util.List;

public class ResouceCatalog {
    private Long id;

    private String name;

    private Date addTime;

    private Long pid;

    private Integer siteType;

    private String classPid;

    private String remark;

    private List<ResouceCatalog> RCList;

    public List<ResouceCatalog> getRCList() {
        return RCList;
    }

    public void setRCList(List<ResouceCatalog> RCList) {
        this.RCList = RCList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public String getClassPid() {
        return classPid;
    }

    public void setClassPid(String classPid) {
        this.classPid = classPid == null ? null : classPid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}