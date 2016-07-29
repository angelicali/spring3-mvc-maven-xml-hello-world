package com.mkyong.web.repository;


import java.util.List;
import com.mkyong.web.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String lastName);
}
