package com.fym.entity;

import java.util.Date;

public class AdConfig {
    private Long id;

    private String name;

    private String adImg;

    private Integer isShow;

    private String remark;

    private String url;

    private Date addTime;

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

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg == null ? null : adImg.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "AdConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adImg='" + adImg + '\'' +
                ", isShow=" + isShow +
                ", remark='" + remark + '\'' +
                ", url='" + url + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}