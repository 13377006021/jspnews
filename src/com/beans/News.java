package com.beans;

import java.util.HashMap;


public class News {
    private int id;
    private String title;
    private String text;
    private int author;
    private int impnews;
    private int slide;
    private String slideImg;
    private String tag;
    private int category;
    private int views;
    private int searchs;
    private int review;
    private int like;
    private HashMap<String, Object> attr = new HashMap<String, Object>();
    public String getSlideImg() {
        return slideImg;
    }

    public void setSlideImg(String slideImg) {
        this.slideImg = slideImg;
    }
    public HashMap<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(HashMap<String, Object> attr) {
        this.attr = attr;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getSearchs() {
        return searchs;
    }

    public void setSearchs(int searchs) {
        this.searchs = searchs;
    }

    private long created;
    private long updated;

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getImpnews() {
        return impnews;
    }

    public void setImpnews(int impnews) {
        this.impnews = impnews;
    }

    public int getSlide() {
        return slide;
    }

    public void setSlide(int slide) {
        this.slide = slide;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public News(int id, String title, String text, int author, int impnews, int slide, String slideImg, String tag, int category, int views, int searchs, int review, int like, long created, long updated) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.impnews = impnews;
        this.slide = slide;
        this.slideImg = slideImg;
        this.tag = tag;
        this.category = category;
        this.views = views;
        this.searchs = searchs;
        this.review = review;
        this.like = like;
        this.created = created;
        this.updated = updated;
    }
}
