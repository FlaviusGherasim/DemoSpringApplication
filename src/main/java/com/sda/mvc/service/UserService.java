package com.sda.mvc.service;

import com.sda.mvc.model.User;
import com.sda.mvc.repository.UserRepository;
import com.sda.mvc.repository.UserRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepositoryIF userRepositoryIF;

    public List<User> findUsersInAgeGroup(int x, int y) {
        return userRepositoryIF.getUsersByAgeBetween(x, y);
    }

    public void saveUser(User user) {
        if (user.getAge() != 0 && user.getName() != null &&
                user.getUsername() != null &&
                user.getEmail() != null &&
                user.getPassword() != null) {
            userRepositoryIF.save(user);
//            userRepository.save(user);
            log.info("All good, we saved this user.");
        } else {
            throw new IllegalArgumentException();
        }
    }

//    public void deleteUser(String username)
//    {
//        List<User> allUsers = userRepository.findAllUsers();
//        allUsers.removeAll(allUsers.stream()
//                .filter(user -> user.getUsername().equals(username))
//                .collect(Collectors.toList()));
//    }

    public Integer deleteUserByUsername(String username) {

        Integer user1 = userRepositoryIF.deleteByUsername(username);
        if (user1 == 0) {
            log.warn("User didn't get game ended");
        } else {
            log.info("user with id " + user1 + " was game ended.");
        }
        return user1;
    }

    public Integer deleteUserById(Integer id) {
        Integer user = userRepositoryIF.deleteByUserId(id);
        if (user != 0) {
            log.info("user with id " + id + " was game ended");
        } else {
            log.warn("user didn't get game ended.");
        }
        return user;
    }
}
