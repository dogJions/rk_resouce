package com.fym.entity;

public class ResouceLable {
    private Long id;

    private String name;

    private Integer siteType;

    private String color;

    private Integer isNews;

    private String remark;

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

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getIsNews() {
        return isNews;
    }

    public void setIsNews(Integer isNews) {
        this.isNews = isNews;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "ResouceLable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", siteType=" + siteType +
                ", color='" + color + '\'' +
                ", isNews=" + isNews +
                ", remark='" + remark + '\'' +
                '}';
    }
}