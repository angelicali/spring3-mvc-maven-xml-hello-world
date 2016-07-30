package com.mkyong.web.service;


import com.mkyong.web.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Integer> {
}
