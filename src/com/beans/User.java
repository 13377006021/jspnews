package com.beans;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String username;
    private String usermail;
    private String password;
    private int usergroup;
    private long created;
    private long updated;
    private long lastlogin;
    private String grava;
    private String ip;
    private Map<String, Object> attr = new HashMap<String, Object>();

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    public User() {
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

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(int usergroup) {
        this.usergroup = usergroup;
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

    public long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getGrava() {
        return grava;
    }

    public void setGrava(String grava) {
        this.grava = grava;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User(int id, String username, String usermail, String password, int usergroup, long created, long updated, long lastlogin, String grava, String ip) {
        this.id = id;
        this.username = username;
        this.usermail = usermail;
        this.password = password;
        this.usergroup = usergroup;
        this.created = created;
        this.updated = updated;
        this.lastlogin = lastlogin;
        this.grava = grava;
        this.ip = ip;
    }
}
