package com.fym.entity;

public class SiteConfig {
    private Long id;

    private String siteName;

    private String seoKeyword;

    private String seoDescription;

    private String siteQuotation;

    private String aboutSummary;

    private String aboutDashang;

    private String aboutErweima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
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

    public String getSiteQuotation() {
        return siteQuotation;
    }

    public void setSiteQuotation(String siteQuotation) {
        this.siteQuotation = siteQuotation == null ? null : siteQuotation.trim();
    }

    public String getAboutSummary() {
        return aboutSummary;
    }

    public void setAboutSummary(String aboutSummary) {
        this.aboutSummary = aboutSummary == null ? null : aboutSummary.trim();
    }

    public String getAboutDashang() {
        return aboutDashang;
    }

    public void setAboutDashang(String aboutDashang) {
        this.aboutDashang = aboutDashang == null ? null : aboutDashang.trim();
    }

    public String getAboutErweima() {
        return aboutErweima;
    }

    public void setAboutErweima(String aboutErweima) {
        this.aboutErweima = aboutErweima == null ? null : aboutErweima.trim();
    }
}