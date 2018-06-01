package com.beans;


public class Set {
    private int id;
    private String key;
    private String value;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private long created;
    private long updated;

    public Set() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Set(int id, String key, String value, int type, long created, long updated) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.type = type;
        this.created = created;
        this.updated = updated;
    }
}
