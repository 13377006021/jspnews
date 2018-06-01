package com.beans;

import java.util.HashMap;
import java.util.Map;


public class Group {
    private int id;
    private String name;
    private String level;
    private Map<String, StringBuffer> attr = new HashMap<String, StringBuffer>();

    public Map<String, StringBuffer> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, StringBuffer> attr) {
        this.attr = attr;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Group(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }
}
