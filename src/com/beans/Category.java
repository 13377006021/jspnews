package com.beans;

import java.util.HashMap;
import java.util.Map;


public class Category {
    private int id;
    private String name;
    private String alias;
    private String describe;
    private Map<String, Integer> attr = new HashMap<String, Integer>();

    public Map<String, Integer> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Integer> attr) {
        this.attr = attr;
    }

    public Category() {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Category(int id, String name, String alias, String describe) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.describe = describe;
    }
}
