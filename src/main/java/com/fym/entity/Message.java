package com.fym.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
    private Long id;

    private String ip;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd  HH-mm-ss")
    private Date addTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                ", addTime=" + addTime +
                ", content='" + content + '\'' +
                '}';
    }
}