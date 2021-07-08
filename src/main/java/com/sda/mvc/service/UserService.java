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
        List<User> allUsers = userRepository.findAllUsers();
        Iterable<User> allUsers2= userRepositoryIF.findAll();

        return allUsers.stream()
                .filter(user -> user.getAge() > x && user.getAge() < y)
                .collect(Collectors.toList());
    }

    public void saveUser(User user)
    {
        if(user.getAge()!=0 && user.getName()!=null &&
                user.getUsername()!=null &&
                user.getEmail()!=null &&
                user.getPassword()!=null)
        {
            userRepositoryIF.save(user);
//            userRepository.save(user);
            log.info("All good, we saved this user.");
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public void deleteUser(String username)
    {
        List<User> allUsers = userRepository.findAllUsers();
        allUsers.removeAll(allUsers.stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList()));
    }
}
