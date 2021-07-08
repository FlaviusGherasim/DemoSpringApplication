//package com.sda.demo;
//
//import com.sda.mvc.model.User;
//import com.sda.mvc.repository.UserRepository;
//import com.sda.mvc.service.UserService;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//import java.util.List;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "com.sda.demo")
//public class Main {
//	private static UserRepository userRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(Main.class, args);
//
//		UserService userService= new UserService(userRepository);
//		List<User> usersInAgeGroup= userService.findUsersInAgeGroup(20, 50);
//		System.out.println(usersInAgeGroup);
//	}
//
//}
