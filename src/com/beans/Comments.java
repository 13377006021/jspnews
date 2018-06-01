package com.beans;

import java.util.HashMap;


public class Comments {
    private int id;
    private int user;
    private String text;
    private long issuedate;
    private int news;
    private int support;
    private int contain;
    private HashMap<String, Object> attr = new HashMap<String, Object>();

    public HashMap<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(HashMap<String, Object> attr) {
        this.attr = attr;
    }

    public Comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(long issuedate) {
        this.issuedate = issuedate;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getContain() {
        return contain;
    }

    public void setContain(int contain) {
        this.contain = contain;
    }

    public Comments(int id, int user, String text, long issuedate, int news, int support, int contain) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.issuedate = issuedate;
        this.news = news;
        this.support = support;
        this.contain = contain;
    }
}
