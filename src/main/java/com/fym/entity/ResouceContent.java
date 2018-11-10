package com.fym.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ResouceContent {
    private Long id;

    private String title;

    private String summary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    private String seoKeyword;

    private String seoDescription;

    private String thumbnailImg;

    private Integer clickCount;

    private String author;

    private Integer isShow;

    private Integer isHome;

    private Integer isNews;

    private Integer catalogId;

    private Integer siteType;

    private Integer isRecommend;

    private String description;

    private String classPid;

    private  String RCatalog;

    public String getRCatalog() {
        return RCatalog;
    }

    public void setRCatalog(String RCatalog) {
        this.RCatalog = RCatalog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword == null ? null : seoKeyword.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg == null ? null : thumbnailImg.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }

    public Integer getIsNews() {
        return isNews;
    }

    public void setIsNews(Integer isNews) {
        this.isNews = isNews;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getClassPid() {
        return classPid;
    }

    public void setClassPid(String classPid) {
        this.classPid = classPid == null ? null : classPid.trim();
    }

    @Override
    public String toString() {
        return "ResouceContent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", addTime=" + addTime +
                ", seoKeyword='" + seoKeyword + '\'' +
                ", seoDescription='" + seoDescription + '\'' +
                ", thumbnailImg='" + thumbnailImg + '\'' +
                ", clickCount=" + clickCount +
                ", author='" + author + '\'' +
                ", isShow=" + isShow +
                ", isHome=" + isHome +
                ", isNews=" + isNews +
                ", catalogId=" + catalogId +
                ", siteType=" + siteType +
                ", isRecommend=" + isRecommend +
                ", description='" + description + '\'' +
                ", classPid='" + classPid + '\'' +
                '}';
    }
}