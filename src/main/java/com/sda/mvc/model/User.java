package com.sda.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue()
    private  Integer userId;

    private String name;
    private String username;
    private String password;
    private String email;
    private int age;

}
