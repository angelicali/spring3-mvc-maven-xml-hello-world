package com.mkyong.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private int id;
    private String name;

    protected User() {}

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

    @Override
    public String toString() {return "userid: "+this.id+"\n name: "+this.name+"\n";}
}
