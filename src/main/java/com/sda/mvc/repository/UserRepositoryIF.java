package com.sda.mvc.repository;


import com.sda.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryIF extends CrudRepository<User, Integer> {
}
