package com.mkyong.web.service;

import com.mkyong.web.model.User;
import com.mkyong.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //@TODO：Guava Lists
    @Transactional
    public String findAllUsers() {
        return userRepository.findAll().toString();
    }

    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }


}
