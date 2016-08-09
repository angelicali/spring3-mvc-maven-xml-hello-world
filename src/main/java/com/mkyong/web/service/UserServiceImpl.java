package com.mkyong.web.service;

import com.mkyong.web.model.User;
import com.mkyong.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements CurdService{

    @Autowired
    private UserRepository userRepository;

    //@TODO：Guava Lists
    @Override
    @Transactional
    public String findAllUsers() {
        return userRepository.findAll().toString();
    }

    @Override
    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }

}
