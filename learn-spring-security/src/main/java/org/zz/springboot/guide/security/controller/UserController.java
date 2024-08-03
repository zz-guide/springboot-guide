package org.zz.springboot.guide.security.controller;

import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.zz.demo3.config.DbUserDetailsManager;
import org.zz.demo3.domain.User;
import org.zz.demo3.request.UserReq;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Resource
//    private DbUserDetailsManager dbUserDetailsManager;
//
//    @GetMapping("/list")
//    public List<User> getList() {
//        List<User> users = new ArrayList<>(DbUserDetailsManager.users.values());
//        return users;
//    }
//
//    @PostMapping("/add")
//    public void addUser(@RequestBody UserReq userReq) {
//        UserDetails user = org.springframework.security.core.userdetails.User.builder()
//                .username(userReq.getUsername())
//                .password(new BCryptPasswordEncoder().encode(userReq.getPassword()))
//                .build();
//        dbUserDetailsManager.createUser(user);
//    }
}
