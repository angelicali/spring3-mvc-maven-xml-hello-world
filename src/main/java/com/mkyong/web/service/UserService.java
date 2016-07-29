package com.mkyong.web.service;

import com.mkyong.web.model.User;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */

@Service        // create UserService as a bean
public class UserService {
    private static int maxN = 100;
    private static User[] userList = new User[maxN];

    public UserService() {
        for(int i=0; i<maxN; i++) {
            userList[i] = new User(i,"Angelica"+i);
        }

    }

    public User findUserById(int id) {
        for(int i=0; i<maxN; i++) {
            if(userList[i].getId() == id){
                return userList[i];
            }
        }
        return null;
    }
}
