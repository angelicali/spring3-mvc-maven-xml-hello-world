package com.mkyong.web.api;

import com.mkyong.web.model.User;
import com.mkyong.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Angelica Yunshu Li on 8/10/2016.
 */


@RestController
@RequestMapping("/api")
public class HelloAPI {

    @Autowired        
    private UserService userService;

    @RequestMapping("/users")
    public List listUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping("/register")
    public User register(@RequestParam String name, @RequestParam int id) {
        User user = new User(id,name);
        userService.saveUser(user);
        return user;
    }

}
