package com.yakeManager.pojo;

public class User {
    private long client_id;
    private String password;
    private String identity;

    public User() {
    }

    public User(long client_id, String password) {
        this.client_id = client_id;
        this.password = password;
    }

    public User(long client_id, String password, String identity) {
        this.client_id = client_id;
        this.password = password;
        this.identity = identity;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
