package com.mkyong.web.service;

import com.google.common.collect.Lists;
import com.mkyong.web.model.User;
import com.mkyong.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelica Yunshu Li on 7/20/2016.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //@TODO：Guava Lists
    @Transactional
    public List findAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }


}
