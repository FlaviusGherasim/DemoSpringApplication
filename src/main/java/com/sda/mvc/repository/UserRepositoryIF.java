package com.sda.mvc.repository;


import com.sda.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryIF extends CrudRepository<User, Integer> {
    Integer deleteByUsername(String username);
    Integer deleteByUserId(Integer id);
    List<User> getUsersByAgeBetween(Integer minAge, Integer maxAge);
}
