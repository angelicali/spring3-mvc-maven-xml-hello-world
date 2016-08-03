package com.mkyong.web.service;

import com.mkyong.web.model.User;
import com.mkyong.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService")
public class UserServiceImpl implements CurdService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public String findAllUsers() {
        return null;
        //return userRepository.findAll().toString();
    }

    @Override
    @Transactional
    public void saveUser(User user){
        ;
        //userRepository.save(user);
    }

}
