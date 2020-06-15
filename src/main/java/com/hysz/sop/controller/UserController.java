package com.hysz.sop.controller;

import com.hysz.sop.entity.User;
import com.hysz.sop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/get/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping(value = "/count")
    public int getUserCount() {
        return service.getUserCount();
    }

    @PostMapping(value = "/list")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody User user) {

        int res = service.addUser(user);
        System.out.println(res);
        return "insert user";
    }

    @PostMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        int res = service.removeUser(id);
        System.out.println(res);
        return "remove user";
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestBody User user) {
        int res = service.updateUser(user);
        System.out.println(res);
        return "update user";
    }
}
