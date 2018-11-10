package com.fym.entity;

public class ResouceVideo {
    private Long id;

    private String title;

    private String url;

    private Integer orderSort;

    private Long contentId;

    private ResouceContent resouceContent;

    public ResouceContent getResouceContent() {
        return resouceContent;
    }

    public void setResouceContent(ResouceContent resouceContent) {
        this.resouceContent = resouceContent;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}