package com.mkyong.web.controller;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
