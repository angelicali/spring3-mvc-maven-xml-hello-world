package com.mkyong.web.controller;

import org.springframework.stereotype.Service;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */

@Service
public class UserService {
    private static int maxN = 10;
    private static User[] userList = new User[maxN];

    public UserService() {
        for(int i=0; i<maxN; i++) {
            userList[i] = new User(i,"Angelica"+i);
        }

    }

    public static User findUserById(int id) {
        for(int i=0; i<maxN; i++) {
            if(userList[i].getId() == id){
                return userList[i];
            }
        }
        return null;
    }
}
