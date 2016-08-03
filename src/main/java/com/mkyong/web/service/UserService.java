package com.mkyong.web.service;

import com.mkyong.web.model.User;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */


public interface UserService {

    void saveUser(User user);

    String findAllUsers();

}
