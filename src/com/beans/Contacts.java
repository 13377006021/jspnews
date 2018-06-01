package com.beans;

import java.util.HashMap;

public class Contacts {
    private int id;
    private String username;
    private String email;
    private String phone;
    private String qq;
    private String title;
    private String content;
    private String ip;
    private long tjdate;

    private HashMap<String, Object> attr = new HashMap<String, Object>();

    public HashMap<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(HashMap<String, Object> attr) {
        this.attr = attr;
    }

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getTjdate() {
        return tjdate;
    }

    public void setTjdate(long tjdate) {
        this.tjdate = tjdate;
    }

    public Contacts(int id, String username, String email, String phone, String qq, String title, String content, String ip, long tjdate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.qq = qq;
        this.title = title;
        this.content = content;
        this.ip = ip;
        this.tjdate = tjdate;
    }
}
