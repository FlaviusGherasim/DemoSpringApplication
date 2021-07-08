package com.sda.mvc.repository;

import com.sda.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    // create, read, update, delete

    // read
//    public User findUserById(int userId){};

//    public User findUserByUsername(String username){};

    List<User> userList;


    @Autowired
    public UserRepository(List<User> userList) {
        this.userList = userList;
        User user1 = new User(1,"David", "david", "123", "email1@gmail.com", 15);
        User user2 = new User(2,"Alex", "alex", "456", "email2@gmail.com", 23);
        User user3 = new User(3,"Paul", "paul", "789", "email3@gmail.com", 49);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public List<User> findAllUsers() {
        return userList;
    }

    // create new user - save
    public void save(User user) {
        userList.add(user);

    }

//    public void delete(User user) {
//        userList.remove(user);
//    }

    public User delete(int index) {
        User user = userList.remove(index);
        return user;
    }
}
