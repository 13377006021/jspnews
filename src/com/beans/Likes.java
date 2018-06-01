package com.beans;

public class Likes {
    private int id;
    private int user_id;
    private long vote_time;
    private int news_id;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getVote_time() {
        return vote_time;
    }

    public void setVote_time(long vote_time) {
        this.vote_time = vote_time;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Likes(int id, int user_id, long vote_time, int news_id, int status) {
        this.id = id;
        this.user_id = user_id;
        this.vote_time = vote_time;
        this.news_id = news_id;
        this.status = status;
    }
}
