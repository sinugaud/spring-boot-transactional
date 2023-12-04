package com.example.service;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
//    private UserRepository userRepository;

    public List<User> getAllUsers() {
        User newUser = new User();
        newUser.setUsername("NewUser");
        newUser.setEmail("newuser@example.com");
        List<User> list = new ArrayList<>();
        list.add(newUser);

        return list;
    }

}
