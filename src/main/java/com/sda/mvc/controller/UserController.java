package com.sda.mvc.controller;

import com.sda.mvc.model.User;
import com.sda.mvc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/cinema/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<String> findAllUsers(@RequestParam(value="minAge", required = false) Integer a,
                                               @RequestParam(value="maxAge", required = false) Integer b)
    {

        if((a==null)|| (b==null))
        {
            return new ResponseEntity<>("Check them ages pal.", HttpStatus.BAD_REQUEST);
        }

       List<User> userListInAgeGroup = userService.findUsersInAgeGroup(a,b);
       log.info("we got here dude.");
       log.debug(userListInAgeGroup.toString());
        return new ResponseEntity<>(userListInAgeGroup.toString(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // creeaza un user nou // TODO Catch Exception
        try {
            userService.saveUser(user);
        }
        catch(IllegalArgumentException e)
        {
            log.info("Something went wrong, IllegalArgumentException");
            return new ResponseEntity<>("There is some missing data, check your request..", HttpStatus.I_AM_A_TEAPOT);
        }
        log.info(user.toString());
        return new ResponseEntity<>(user.toString(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam(value = "username") String username)
    {
        try {
            userService.deleteUser(username);
        }
        catch(IllegalArgumentException e)
        {
            log.info("Something went wrong with the username, IllegalArgumentException");
        }
        return new ResponseEntity<>("User with username " + username + " has been removed.", HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
